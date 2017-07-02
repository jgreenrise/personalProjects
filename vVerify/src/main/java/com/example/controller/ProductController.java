package com.example.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.domain.Product;
import com.example.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@RequestMapping("/product")
	public @ResponseBody Collection<Product> getProducts() {
		return service.getAllProducts();
	}

	@RequestMapping("/product/{productId}")
	public @ResponseBody Product getProduct(@PathVariable("productId") final String productId) {
		return service.getProduct(productId);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping("/product/save")
	public @ResponseBody Product saveProduct(@RequestBody final Product product) {
		return service.createProduct(product);
	}

	@RequestMapping(value = "/product/{productId}/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> uploadFile(@PathVariable("productId") final String productId, 
			@RequestParam("file") MultipartFile uploadfile) {
		try {
			// Get the filename and build the local file path
			String filename = uploadfile.getOriginalFilename();
			String directory = "";
			String filepath = Paths.get(directory, filename).toString();

			// Save the file locally
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			stream.write(uploadfile.getBytes());
			stream.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	} // method uploadFile

}
