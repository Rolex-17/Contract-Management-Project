package contract;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import contract.models.AdminUser;
import contract.services.AdminuserService;

@SpringBootApplication
public class ContractManagementApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ContractManagementApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ContractManagementApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AdminuserService srv) {
	    return (args) -> {
	    	if(srv.countUser()==0) {
	    		AdminUser user=new AdminUser();
	    		user.setUserid("admin");
	    		user.setPwd("admin123");
	    		user.setName("Administrator");
	    		srv.saveAdmin(user);
	    		log.info("Admin user created successfully");
	    	}else {
	    		log.info("Admin user already created");
	    	}
	    };
	}
}
