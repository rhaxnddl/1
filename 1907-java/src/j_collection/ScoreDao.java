package j_collection;

import java.util.HashMap;
import java.util.Map;

public class ScoreDao {

	private void insert(ScoreVo vo) {
		Map<ScoreVo, String> map = new HashMap<ScoreVo, String>();
		
		map.put(new ScoreVo("2019001","kim", "중간", 4, 90, 80, 60, 80, 0), "010-111-1111");
		map.put(new ScoreVo("2019002", "lee", "기말", 3, 50, 70, 90, 100, 0), "010-222-2222");
		map.put(new ScoreVo("2019003", "pack", "중간", 1, 70, 60, 80, 95, 0), "010-333-3333");
	}
	public void update(String sno, ScoreVo vo) { // 수정
		
	}
	public void delete(String sno) { // 삭제
		
	}
	public void list(String findStr) { // 조회
		
	}
}
