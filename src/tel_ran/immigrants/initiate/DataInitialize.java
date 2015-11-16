package tel_ran.immigrants.initiate;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import tel_ran.immigrants.repositories.CountriesData;



public class DataInitialize implements BeanPostProcessor {
		

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("HERE");
		if(beanName.equals("countryBase")) {
			
			if(((CountriesData)bean).isCountryDataNotEmplty())
				System.out.println("DB full");
			else {
				System.out.println("DB empty");
				CountryInitializing ci = new CountryInitializing((CountriesData) bean);
			}
		}
				
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		// TODO Auto-generated method stub
		return arg0;
	}

}
