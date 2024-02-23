package com.sist.service;
import java.util.*;
import com.sist.vo.*;
public interface ReserveService {
	public List<FoodVO> foodReserveData(String type);
	public void foodReserveInsert(ReserveVO vo);
	public List<ReserveVO> reserveMypageData(String userId);
}
