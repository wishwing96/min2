package com.min.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.mapper.RepBoardMapper;
import com.min.model.Criteria;
import com.min.model.RepBoardVO;

@Service
public class RepBoardServiceImpl implements RepBoardService {
	
	@Autowired
	private RepBoardMapper rbm;
	
	@Override
	public List<RepBoardVO> repboardList() throws Exception {
		return rbm.repboardList();
	}
	
	@Override
	public List<RepBoardVO> repboardListPaging(Criteria cri) throws Exception {
		return rbm.repboardListPaging(cri);
	}
	
	@Override
	public void repboardDetail(int bno) throws Exception {
		rbm.repboardDetail(bno);
	}

	@Override
	public void repboardWrite(RepBoardVO vo) throws Exception {
		rbm.repboardWrite(vo);
	}

	@Override
	public void repboardModify(RepBoardVO vo) throws Exception {
		rbm.repboardModify(vo);
		
	}

	@Override
	public void repboardDelete(RepBoardVO vo) throws Exception {
		rbm.repboardDelete(vo);
		
	}

}
