package com.myroutine.web.dao;

import java.util.List;

import com.myroutine.web.entity.admin.exercise.ExerciseFile;

public interface ExerciseFileDao {

	List<ExerciseFile> getFileList(int exerciseId) ;
	
}
