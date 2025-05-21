package dlk.wti.spring.db.transactional.basic;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@Service
public class DbTransactionalBasicService {
	
    private final DbTransactionalBasicRepository dbTransactionalBasicRepository;
    public DbTransactionalBasicService(DbTransactionalBasicRepository dbTransactionalBasicRepository) {this.dbTransactionalBasicRepository = dbTransactionalBasicRepository;}

	public void createNoneTrans(DbCrudDTO dbCrudDTO, String errorOption) {
		
		dbTransactionalBasicRepository.create(dbCrudDTO);

		if(errorOption.equals("Y")) {
			DbCrudDTO errorDTO = new DbCrudDTO();
			errorDTO.setTitle(null);
			errorDTO.setName(null);
			errorDTO.setContent(null);
			dbTransactionalBasicRepository.create(errorDTO);
		}
	}
	
	@Transactional(
	    // 1. 전파 방식 (REQUIRED (기본값): 현재 트랜잭션이 있으면 참여하고, 없으면 새로 생성)
	    propagation = Propagation.REQUIRED,
	    // 2. 격리 수준 (READ_UNCOMMITTED: 커밋되지 않은 데이터 읽기 가능 (다른 트랜잭션의 변경사항 볼 수 있음))
	    isolation = Isolation.READ_COMMITTED,
	    // 3. 제한 시간 (지정한 시간 내에 트랜잭션이 완료되지 않으면 롤백)
	    timeout = 30,
	    // 4. 읽기 전용 여부 (true : 데이터 변경 작업 불가능, 읽기 작업만 가능 / false (기본값): 데이터 변경 작업 가능)
	    readOnly = false
	)
	public void createWithTrans(DbCrudDTO dbCrudDTO, String errorOption) {
		
		dbTransactionalBasicRepository.create(dbCrudDTO);
		
		if(errorOption.equals("Y")) {
			DbCrudDTO errorDTO = new DbCrudDTO();
			errorDTO.setTitle(null);
			errorDTO.setName(null);
			errorDTO.setContent(null);
			dbTransactionalBasicRepository.create(errorDTO);
		}
	}
}