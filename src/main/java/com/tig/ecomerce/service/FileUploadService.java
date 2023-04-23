package com.tig.ecomerce.service;

import java.io.InputStream;

public interface FileUploadService {
	void uploadFile(InputStream inputStream, String nameImg);
}
