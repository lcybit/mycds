package com.jefflee.service.screening.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.jefflee.dto.TestDto;
import com.jefflee.entity.Test;
import com.jefflee.service.base.impl.BaseServiceImpl;
import com.jefflee.service.screening.TestService;
import com.jefflee.util.BeanUtil;
import com.jefflee.util.DatabaseUtil;

@Service("testService")
public class TestServiceImpl extends BaseServiceImpl<TestDto, Test, String> implements TestService {

	public TestServiceImpl() {
		mapperName = "TestMapper";
	}

	@Override
	public TestDto create(TestDto testDto) throws Exception {
		// Insert test
		String testId = DatabaseUtil.gnr32Uuid();
		Test test = new Test();
		BeanUtil.copyProperties(testDto, test);
		test.setTestId(testId);
		if (1 == baseDao.insert(mapperName + ".insert", test)) {
			BeanUtil.copyPropertiesIgnoreNull(test, testDto);
			return testDto;
		}
		return null;
	}

	@Override
	public TestDto findById(String testId) throws Exception {
		Test test = baseDao.selectOne(mapperName + ".selectOne", testId);
		TestDto testDto = new TestDto();
		BeanUtil.copyProperties(test, testDto);
		return testDto;
	}

	@Override
	public List<TestDto> findList() throws Exception {
		List<Test> testList = baseDao.selectList(mapperName + ".selectList", null);
		List<TestDto> testDtoList = new ArrayList<TestDto>();
		for (Test test : testList) {
			TestDto testDto = new TestDto();
			BeanUtil.copyProperties(test, testDto);
			testDtoList.add(testDto);
		}
		return testDtoList;
	}

	@Override
	public List<TestDto> findRecommondedList(String resultId) throws Exception {
		// TODO implement the selection algorithm here
		List<TestDto> testDtoList = findList();
		Random random = new Random();
		int size = testDtoList.size();
		for (int i = 0; i < size - 3; i++) {
			testDtoList.remove(random.nextInt(testDtoList.size()));
		}
		return testDtoList;
	}

	@Override
	public TestDto modify(TestDto testDto) throws Exception {
		Test test = new Test();
		BeanUtil.copyProperties(testDto, test);
		if (1 == baseDao.update(mapperName + ".update", test)) {
			return testDto;
		}
		return null;
	}

}
