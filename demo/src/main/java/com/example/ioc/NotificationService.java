package com.example.ioc;

import java.util.List;

public interface NotificationService {

	List<String> getListado();

	void add(String message);

	void delete(int index);

	void clear();

}