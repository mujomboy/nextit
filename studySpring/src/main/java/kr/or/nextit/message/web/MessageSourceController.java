package kr.or.nextit.message.web;

import java.util.Locale;
import java.util.Properties;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessageSourceController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="propertyService")
	private Properties propertiesService;
	
	@Resource(name="messageSource")
	private MessageSource messageSource;
			
	@RequestMapping(value="/message/messageSource.do")
	public String testMessageSource(
			Locale locale
			) throws Exception {
		
//		messageSource.getMessage(code, args, locale)
		
		log.debug("message : {} ", messageSource.getMessage("title.sample.name", null, locale));

		
		log.debug("message : {} ", messageSource.getMessage("errors.minlength", new Object[] {"이름은", "3"}, locale));
		log.debug("message : {} ", messageSource.getMessage("errors.maxlength", new Object[] {"나이는", "5"}, locale));
		log.debug("message : {} ", messageSource.getMessage("errors.test", new Object[] {"이름은", "3"}, locale));
		log.debug("message : {} ", messageSource.getMessage("errors.title", new Object[] {"나이는", "5"}, locale));

		
		return "message/messageSource";
	}
}
