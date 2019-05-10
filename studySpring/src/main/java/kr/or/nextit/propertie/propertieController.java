package kr.or.nextit.propertie;

import java.util.Properties;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class propertieController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name ="propertyService")
	private Properties propertiesService;
	
	@RequestMapping(value="/properties/propertiesFront.do")
	public String testPropertiesFront() throws Exception {
		
		propertiesService.getProperty("dev.driver");
		log.debug("dev.driver : {} ", propertiesService.getProperty("dev.driver"));
		
		log.debug("server.save.path : {} ", propertiesService.getProperty("server.save.path"));
		log.debug("server.save.url : {} ", propertiesService.getProperty("server.save.url"));
		
		
		return "properties/propertiesFront";
	}
}
