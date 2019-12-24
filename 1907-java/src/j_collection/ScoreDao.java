package j_collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ScoreDao {
	Map<String, List<ScoreVo>> map;
	
	public ScoreDao(Map<String, List<ScoreVo>> map) {
		this.map = map;
	}
	public boolean insert (ScoreVo vo) {
		boolean b = true;
	try {
		String key = vo.getSno();
		if(map.containsKey(key)) {
			List<ScoreVo> list = map.get(key);
			list.add(vo);
			
		}else { // key가 없는 경우(학생이 없는경우)
			List<ScoreVo> list = new ArrayList<ScoreVo>();
			list.add(vo);
			
			map.put(key, list);
		}
	} catch(Exception ex) {
		b = false;
	}
		return b;
	}
	public boolean update (String key,  int index, ScoreVo vo) { // 수정
		boolean b = true;
		
		try {
			List<ScoreVo> list = map.get(key);
			list.set(index, vo);
		}catch(Exception ex) {
			b = false;
		}
		return b;
	}
	public boolean delete (String sno, int index) { // 삭제
		boolean b = true;
		try {
			List<ScoreVo> list = map.get(sno);
			list.remove(index);
		}catch(Exception ex) {
			b = false;
		}
		return b;
	}
	public Map<String, List<ScoreVo>> list (String findStr) { // 조회
		Map<String, List<ScoreVo>> newMap = new HashMap<String, List<ScoreVo>>();
		
		Set<String> set = map.keySet();
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			if(key.indexOf(findStr)>=0) {
				newMap.put(key, map.get(key));
			}
		}
		
		
		return newMap;
	}
}
