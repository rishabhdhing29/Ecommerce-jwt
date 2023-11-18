package com.hexaware.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hexaware.ecommerce.dto.AdminDTO;
import com.hexaware.ecommerce.entities.Admin;
import com.hexaware.ecommerce.repository.AdminRepository;



@Service
public class AdminServiceImp implements IAdminService {

	@Autowired
	AdminRepository adminRepo;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Admin createAdmin(AdminDTO adminDTO) {
		Admin admin = new Admin();
		admin.setAdminId(adminDTO.getAdminId());
		admin.setAdminName(adminDTO.getAdminName());
		admin.setAdminUserName(adminDTO.getAdminUserName());
		admin.setAdminPassword(passwordEncoder.encode(adminDTO.getAdminPassword()));
		admin.setAdminContact(adminDTO.getAdminContact());
		admin.setAdminEmail(adminDTO.getAdminEmail());
		admin.setRoles(adminDTO.getRoles());
		return adminRepo.save(admin);
	}

	@Override
	public Admin updateAdmin(AdminDTO adminDTO) {
		Admin admin = adminRepo.findById(adminDTO.getAdminId()).orElse(new Admin());
		admin.setAdminId(adminDTO.getAdminId());
		admin.setAdminName(adminDTO.getAdminName());
		admin.setAdminUserName(adminDTO.getAdminUserName());
		admin.setAdminPassword(adminDTO.getAdminPassword());
		admin.setAdminContact(adminDTO.getAdminContact());
		admin.setAdminEmail(adminDTO.getAdminEmail());
		admin.setRoles(adminDTO.getRoles());
		return adminRepo.save(admin);
	}

	@Override
	public void deleteAdmin(int adminId) {
		Admin admin = adminRepo.findById(adminId).orElse(null);
		adminRepo.delete(admin);

	}

	@Override
	public AdminDTO getAdminById(int adminId) {
        Admin admin = adminRepo.findById(adminId).orElse(new Admin());
        return new AdminDTO(admin.getAdminId(),admin.getAdminName(),admin.getAdminUserName(),admin.getAdminPassword(),admin.getAdminContact(),admin.getAdminContact(),admin.getRoles());

	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepo.findAll(Sort.by("adminName"));
	}

	@Override
	public Optional<Admin> findByadminUserName(String username) {

		return adminRepo.findByadminUserName(username);
	}



}
