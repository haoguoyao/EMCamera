package com.hgy.repository;

import java.util.List;

import com.hgy.model.CClazz;

public interface CClazzService {
	public List<CClazz> findClazzByTeacherId(int id);
	public CClazz findClazzById(int id);
}
