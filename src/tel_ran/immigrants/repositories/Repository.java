package tel_ran.immigrants.repositories;



import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;


public class Repository {
	
	@PersistenceContext(unitName="springHibernate")
	EntityManager em;
	
	public String[] runRequest(String jpqlStr) {
		String res[];
		if(isSingleRequest(jpqlStr))
			res=runSingleRequest(jpqlStr);
		else
			res=runMultipleRequest(jpqlStr);
		return res;
	}
	private String[] runMultipleRequest(String jpqlStr) {
		Query query=em.createQuery(jpqlStr);
		List<Object[]> res=query.getResultList();
		return arrayObjectsToArrayStrings(res);
	}
	private String[] arrayObjectsToArrayStrings(List<Object[]> list) {
		String [] res=new String[list.size()];
		int iRes=0;
		for(Object[] arObj:list){
			String str=arObj[0].toString();
			for(int i=1;i<arObj.length;i++){
				str=str+" "+arObj[i].toString();
			}
			res[iRes++]=str;
		}

		return res;
	}
	private String[] runSingleRequest(String jpqlStr) {
		Query query=em.createQuery(jpqlStr);
		List<Object> res=query.getResultList();
		return objectsToArrayString(res);
	}
	private String[] objectsToArrayString(List<Object> list) {
		String [] res=new String[list.size()];
		int iRes=0;
		for(Object obj:list)
			res[iRes++]=obj.toString();
		return res;
	}
	private boolean isSingleRequest(String jpqlStr) {
		int indFrom=jpqlStr.indexOf("FROM");
		String upFrom=jpqlStr.substring(0, indFrom);
		String [] tokens=upFrom.split(",");
		return tokens.length<=1;
	}

//	@Transactional(readOnly=false)
//	public long addPerson(String email, String password, long birthPlace_id, String firstName, String lastName) {
//		long personId = 0;
//
//		Query query = em.createQuery("SELECT p FROM Person p WHERE p.email LIKE :parName");
//		query.setParameter("parName", email);
//		List<Person> res = query.getResultList();
//		if(res.isEmpty())
//		{
//			PersonData pd = addPersonData( birthPlace_id,  firstName,  lastName);
//			if(pd != null)
//			{
//				Person p = new Person();
//				p.setEmail(email);
//				p.setPassword(password);
//				p.setRegDate(new Date());
//				p.setPersonData(pd);
//
//				em.persist(p);
//				personId = p.getId();
//			}
//		}
//		else
//		{
//				
//			System.out.println("Person: " + res.get(0).toString() + " already exists.");
//			personId = res.get(0).getId();
//		}	
//
//		return personId;
//	}
	
//	public void addPersonData(String str, long id) {	
//		Person p = em.find(Person.class, id);
//		PersonData pd = p.getPersonData();
//		
//		em.merge(pd);
//	}
//	public void changePerson(Date date, long id) {
//		
//		Person p = em.find(Person.class, id);
//		
//		p.setRegDate(date);
//		em.merge(p);		
//	}
//	
//	@Transactional(readOnly=false)
//	public long addCountry(String name,String link)
//	{
//		long id_ret = 0;
//		Query query = em.createQuery("SELECT c FROM Country c WHERE c.name LIKE :parName");
//		query.setParameter("parName", name);
//		List<Country> res = query.getResultList();
//		if(res.isEmpty())
//		{
//			Country country = new Country();
//			country.setName(name);
//			country.setLink(link);
//			em.persist(country);
//			System.out.println("Country: " + name + " was added.");
//			id_ret = country.getId();
//		}
//		else
//		{
//			System.out.println("Country: " + name + " already exists.");
//			id_ret = res.get(0).getId();
//		}	
//	
//		return id_ret;
//	}
		
//	@Transactional(readOnly=false)
//	public void addCitizenship(long person_id, long country_id)
//	{	
//		Person p = em.find(Person.class, person_id);
//		Country country = em.find(Country.class, country_id);
//		if(p != null && country != null)
//		{
//			PersonData pd = p.getPersonData();
//			if(pd != null)
//			{
//				boolean bAlreadyHas = false;
//				// Check if person already had this citizenship
//				List<Country> country_list = pd.getPerson_citizenships();
//				if(!country_list.isEmpty())
//				{
//					for(Country c:country_list)
//					{
//						if(c.getId() == country.getId())
//						{
//							bAlreadyHas = true;
//							break;
//						}
//					}
//				}
//				
//				if(!bAlreadyHas)
//				{
//					pd.addPerson_citizenship(country);
//					country.addCountry_citizen(pd);
//					em.persist(pd);
//				}
//			}
//		}	
////	}
//	@Transactional(readOnly=false)
//	public void addFamilyMember(long person_id, String relation,long birthPlace_id,  String firstName, String lastName)
//	{	
//		Person p = em.find(Person.class, person_id);
//		
//	
//		if(p != null)
//		{
//			FamilyMember famMem = new FamilyMember();
//			famMem.setParentPerson(p);
//			famMem.setRelation(relation);
//			List<FamilyMember>family_list = p.getFamily();
//			if(family_list == null)
//			{
//				family_list = new ArrayList<FamilyMember>();
//				
//			}
//			family_list.add(famMem);
//			p.setFamily(family_list);
//			PersonData pd = addPersonData( birthPlace_id,  firstName,  lastName);
//			if(pd != null)
//			{
//				famMem.setPersonData(pd);
//			}
//			
//			em.persist(famMem);
//		}	
////	}
//	@Transactional(readOnly=false)
//	public PersonData addPersonData(long birthPlace_id, String firstName, String lastName)
//	{
//		PersonData pd = null;
//		Country birthPlace = em.find(Country.class, birthPlace_id);
//		if(birthPlace != null)
//		{
//		    pd = new PersonData();
//			pd.setBirthPlace(birthPlace);
//			pd.setFirstName(firstName);
//			pd.setLastName(lastName);
//			em.persist(pd);
//			
//			List<PersonData> list_pd = birthPlace.getPersonDatas();
//			if(list_pd.isEmpty())
//			{
//				list_pd = new ArrayList<PersonData>();
//			}
//			list_pd.add(pd);
//			birthPlace.setPersonDatas(list_pd);
//		
//			em.merge(birthPlace);
//			
//			
//
//		}
//		return pd;
//		
//		
//	}
//	@Transactional(readOnly=false)
//	public void addAddressByPersonData(long personData_id, String street, String region, String bld, 
//			String city, int appr, long country_id)
//	{
//		
//		PersonData pd = em.find(PersonData.class, personData_id);
//		Country country = em.find(Country.class, country_id);
//		if(pd != null && country != null)
//		{
//			Address address = new Address();
//			address.setStreet(street);
//			address.setRegion(region);
//			address.setBld(bld);
//			address.setCity(city);
//			address.setAppr(appr);
//			address.setAddres_country(country);
//			address.setPersonData(pd);
//			em.persist(address);
//
//			List<Address> list_address = country.getAddresses();
//			list_address.add(address);
//			country.setAddresses(list_address);
//			em.merge(country);
//			
//			list_address = pd.getAddresses();
//			list_address.add(address);
//			pd.setAddresses(list_address);
//			em.merge(pd);
//		
//		
//		}
//		
//		
//		
//	}
//	public long GetPersonDataIdByPersonId(long person_id)
//	{
//		long personData_id = 0;
//		Person p = em.find(Person.class,person_id);
//		if(p != null)
//		{
//			personData_id = p.getPersonData().getId();
//		}
//		return personData_id;
//		
//	}
//	@Transactional(readOnly=false)
//	public long addEmbassy(String phone,String link,long country_id,String street, String region, String bld, 
//			String city, int appr)
//	{
//		long id_ret = 0;
//		Embassy embassy = new Embassy();
//		Country country = em.find(Country.class, country_id);
//		if(country != null)
//		{
//			Address address = new Address();
//			address.setStreet(street);
//			address.setRegion(region);
//			address.setBld(bld);
//			address.setCity(city);
//			address.setAppr(appr);
//			address.setAddres_country(country);
//			em.persist(address);
//			
//			
//			embassy.setEmbassy_address(address);
//			embassy.setLink(link);
//			embassy.setPhone(phone);
//			embassy.setCountry(country);
//			List<Embassy>embassys = country.getEmbassys();
//			embassys.add(embassy);
//			address.setEmbassy(embassy);
//		}
//			
//		id_ret = embassy.getId();
//		em.persist(embassy);
//		System.out.println("Embassy: " + country.getName() + " was added.");
//		return id_ret;
//		
//	}
	
//	@Transactional(readOnly=false)
//	public long addProgram(String name, String category, String link, String description,long country_id,
//			int minAge, int maxAge,String education,String occupation,String maritalStatus,String religiousBackground)
//	{
//		long id_ret = 0;
//		long requirements_id = 0;
//		Country country = em.find(Country.class, country_id);
//		if (country != null)
//		{
//			Program program = new Program();
//			program.setCategory(category);
//			program.setDescription(description);
//			program.setLink(link);
//			program.setName(name);
//			program.setProgr_country(country);
//			List<Program>programs = country.getPrograms();
//			programs.add(program);
//			country.setPrograms(programs);
//			em.merge(country);
//			
//			Requirements requirements = addRequirements(program, minAge, maxAge,education,occupation,maritalStatus,religiousBackground);
//			program.setRequiremens(requirements);
//
//		    em.persist(requirements);
//			em.persist(program);
//			id_ret = program.getId();
//
//			System.out.println("program: " + program.getName() + " was added.");
//		}
//		else
//		{
//			System.out.println("Country not found. Create a country");
//		}
//
//		return id_ret;
//		
//	}
//	
//	public Requirements addRequirements(Program program, int minAge, int maxAge,String education,String occupation,String maritalStatus,
//			String religiousBackground)
//	{
//		long id_doc = 0;
//		long ret_id = 0;
//		Requirements requirements = new Requirements();
//		requirements.setProgram(program);
//		requirements.setEducation(education);
//		requirements.setMaritalStatus(maritalStatus);
//		requirements.setMaxAge(maxAge);
//		requirements.setMinAge(minAge);
//		requirements.setOccupation(occupation);
//		requirements.setReligiousBackground(religiousBackground);
//		ret_id = requirements.getRequirements_id();
//		
//			
//		return requirements;
//	}
//	@Transactional(readOnly=false)
//	public long addDocument(String type,String image,long requirements_id)
//	{
//		long id_ret = 0;
//		Document doc = new Document();
//		doc.setType(type);
//		doc.setImage(image);
//		Requirements requirements = em.find(Requirements.class,requirements_id);
//		if(requirements != null)
//		{
//			List<Document> documents = requirements.getDocuments();
//			if(documents == null || documents.isEmpty())
//			{
//				documents = new ArrayList<Document>();
//				
//			}
//			documents.add(doc);
//			requirements.setDocuments(documents);
//			em.merge(requirements);
//			doc.setRequirements(requirements);
//			em.persist(doc);
//			id_ret = doc.getId();
//	}
//				
//		return id_ret;
//	}
//	public long GetIdRequirementsByIdProgram(long id_program)
//	{
//		long id_req = 0;
//		Program program = em.find(Program.class,id_program);
//		if(program != null)
//		{
//			Requirements req = program.getRequiremens();
//			id_req = req.getRequirements_id();
//		}
//		
//		
//		return id_req;
//	}
//	
//	@Transactional(readOnly=false)
//	public long addFieldNames( String name, String possibleValues)
//	{
//		
//		long id_ret = 0;
//		FieldNames fieldNames = new FieldNames();
//		fieldNames.setName(name);
//		fieldNames.setPossibleValues(possibleValues);
//		em.persist(fieldNames);
//		id_ret = fieldNames.getId();
//		System.out.println("FieldNames " + fieldNames.getName() +"is added");
//		
//		return id_ret;
//		
//	}
//	@Transactional(readOnly=false)
//	public long addPersonCustomDataByFieldNamesAndByPersonData(long fieldNames_id, String value,long personData_id)
//	{
//		long id_ret = 0;
//		FieldNames fm = em.find(FieldNames.class, fieldNames_id);
//		PersonData pd = em.find(PersonData.class, personData_id);
//		if( fm != null && pd != null)
//		{
//			PersonCustomData pcd = new PersonCustomData();
//			pcd.setValue(value);
//			pcd.setFieldNames(fm);
//			pcd.setPersonData(pd);
//			
//			
//			List<PersonCustomData>pcdatas = fm.getPersonCustomData();
//			pcdatas.add(pcd);
//			
//			em.persist(pcd);
//			fm.setPersonCustomData(pcdatas);
//			
//			pcdatas = pd.getPersonCustomDatas();
//			pcdatas.add(pcd);
//			pd.setPersonCustomDatas(pcdatas);
//			System.out.println("PersonCustomData " + pcd.getValue() +" is added by the FieldNames  " + fm.getName() + "and by the PersonData  " + pd.getFirstName()+ " "
//					            + pd.getLastName());
//			em.merge(fm);
//			
//			id_ret = pcd.getId();
//		}
//		return id_ret;
//		
//		
//	}
//	@Transactional(readOnly=false)
//	public long addProgramCustomDataByFieldNamesAndByRequirements(long fieldNames_id, String value,long requirements_id)
//	{
//		long id_ret = 0 ;
//		FieldNames fm = em.find(FieldNames.class, fieldNames_id);
//		Requirements req = em.find(Requirements.class, requirements_id);
//		if( fm != null && req != null)
//		{
//			ProgramCustomData progcd = new ProgramCustomData();
//			progcd.setFieldNames(fm);
//			progcd.setValue(value);
//			progcd.setRequirements(req);
//			
//			List<ProgramCustomData>progcdatas = fm.getProgramCustomData();
//			progcdatas.add(progcd);
//			em.persist(progcd);
//			fm.setProgramCustomData(progcdatas);
//			progcdatas = req.getProgramCustomDatas();
//			progcdatas.add(progcd);
//			req.setProgramCustomDatas(progcdatas);
//			System.out.println("ProgramCustomData " + progcd.getValue() +" is added by the FieldNames  " + fm.getName() + "  and by the Requirements  "
//			                  + req.getRequirements_id());
//			em.merge(fm);
//			id_ret = progcd.getId();
//			
//			
//		}
//		return id_ret;
//		
//	}
//	@Transactional(readOnly=false)
//	public long addPersonDocumentByPersonDataId(long personData_id, String documentType, String linkToImage, String language, String translations ,boolean isTemporary ,
//			    Date expirationDate)
//	{
//		
//		long person_doc_id = 0;
//		PersonData pd = em.find(PersonData.class, personData_id);
//		if(pd != null)
//		{
//			PersonDocuments persDoc = new PersonDocuments();
//			persDoc.setDocumentType(documentType);
//			persDoc.setExpirationDate(expirationDate);
//			persDoc.setLanguage(language);
//			persDoc.setLinkToImage(linkToImage);
//			persDoc.setTemporary(isTemporary);
//			persDoc.setPersonData(pd);
//			persDoc.setTranslations(translations);
//			em.persist(persDoc);
//			
//			List<PersonDocuments> persondocs = pd.getPersonDocuments();
//			persondocs.add(persDoc);
//			pd.setPersonDocuments(persondocs);
//			
//			em.merge(pd);
//			System.out.println("PersonDocument " + persDoc.getId() +" Type  " + persDoc.getDocumentType() + "  added to PersonData id =   " + pd.getId() +
//					"   date " + persDoc.getExpirationDate());
//			person_doc_id = persDoc.getId();
//	    }
//				return person_doc_id;
//				
//		}
//	@Transactional(readOnly=false)
//	public long addWayByPersonDataId(long personData_id, long program_id , Date startDate ,Date endDate ,boolean isFinished)
//	{
//		long way_id = 0;
//		PersonData pd = em.find(PersonData.class, personData_id);
//		Program p = em.find(Program.class, program_id);
//		if(pd != null && p != null)
//		{
//			Way way = new Way();
//			way.setEndDate(endDate);
//			way.setStartDate(startDate);
//			way.setFinished(isFinished);
//			way.setPersonData(pd);
//			way.setProgram(p);
//			
//			em.persist(way);
//			
//			List<Way>ways = pd.getWays();
//			ways.add(way);
//			pd.setWays(ways);
//			em.merge(pd);
//			
//			ways = p.getWays();
//			ways.add(way);
//			p.setWays(ways);
//			em.merge(p);
//			 
//			
//			System.out.println("way " + way.getId() +  "  of program  " + p.getId()  +"  is added to PersonData  id =  " +  pd.getId()    );
//			way_id =way.getId();
//		}
//		return way_id;
//		
//	}
//	@Transactional(readOnly=false)
//	public long addWayStepByWayId(long way_id, long program_step_id, boolean isDone , String information)
//	{
//		
//		long id_way_steps = 0;
//		Way  way = em.find(Way.class, way_id);
//		ProgramSteps ps = em.find(ProgramSteps.class, program_step_id);
//		if( way != null && ps != null)
//		{ 
//			
//			WaySteps waystep = new WaySteps();
//			waystep.setInformation(information);
//			waystep.setWay(way);
//			waystep.setDone(isDone);
//			waystep.setProgramSteps(ps);
//			em.persist(waystep);
//			
//			List<WaySteps>waysteps = way.getWaySteps();
//			if(waysteps == null || waysteps.isEmpty())
//			{
//				waysteps = new ArrayList<WaySteps>();
//			}
//			waysteps.add(waystep);
//			way.setWaySteps(waysteps);
//			
//			em.merge(way);
//			
//			waysteps = ps.getWaysteps();
//			waysteps.add(waystep);
//			ps.setWaysteps(waysteps);
//			 em.merge(ps);
//			System.out.println("wayStep "  + waystep.getId() + "   is added  By Way " + way.getId());
//			id_way_steps = waystep.getId();
//			
//		}
//		
//		return id_way_steps;
//	}
//	@Transactional(readOnly=false)
//	public long addProgramStepByProgramId(long id_program, String about, String stepType)
//	{
//		long id_programStep = 0;
//		Program p = em.find(Program.class, id_program);
//		if( p != null)
//		{
//			ProgramSteps ps = new ProgramSteps();
//			ps.setAbout(about);
//			ps.setStepType(stepType);
//			ps.setProgram(p);
//			em.persist(ps);
//			
//			List<ProgramSteps> programSteps = p.getProgramSteps();
//			programSteps.add(ps);
//			p.setProgramSteps(programSteps);
//			em.merge(p);
//			id_programStep = ps.getId();
//			System.out.println("ProgramStep " + ps.getId() + "is added to program " + p.getId());
//		}
//		return id_programStep;
//		
//	}
//	@Transactional(readOnly=false)
//	public long addWayDocumentByPersonDocument(long id_way, long id_personDocument,boolean isReady)
//	{
//		long id_wayDoc = 0;
//		Way way = em.find(Way.class, id_way);
//		PersonDocuments pd = em.find(PersonDocuments.class, id_personDocument);
//		if(way != null && pd != null)
//		{
//			WayDocuments wd = new WayDocuments();
//			wd.setWay(way);
//			wd.setReady(isReady);
//			wd.setPersondocument(pd);
//			wd.setDocument(null);
//			em.persist(wd);
//			System.out.println("WayDocument id = " + wd.getId()  + "is added  by PersonDocument id=  "  + pd.getId()  + "  and by way  id = "  + way.getId());
//			
//			List<WayDocuments>waydocuments = way.getWaydocuments();
//			waydocuments.add(wd);
//			way.setWaydocuments(waydocuments);
//			em.merge(way);
//			waydocuments = pd.getWaydocuments();
//			waydocuments.add(wd);
//			pd.setWaydocuments(waydocuments);
//			em.merge(pd);
//			
//			
//			
//			id_wayDoc = wd.getId();
//			
//		}
//		
//		return id_wayDoc;
//			
//	}
	
//	@Transactional(readOnly=false)
//	public long addWayDocumentByDocument(long id_way, long id_Document,boolean isReady)
//	{
//		long id_wayDoc = 0;
//		Way way = em.find(Way.class, id_way);
//		Document d = em.find(Document.class, id_Document);
//		if(way != null && d != null)
//		{
//			WayDocuments wd = new WayDocuments();
//			wd.setWay(way);
//			wd.setReady(isReady);
//			wd.setDocument(d);
//			wd.setPersondocument(null);
//			em.persist(wd);
//			System.out.println("WayDocument id = " + wd.getId()  + "is added  by Document id=  "  + d.getId()  + "  and by way  id = "  + way.getId());
//			
//			List<WayDocuments>waydocuments = way.getWaydocuments();
//			waydocuments.add(wd);
//			way.setWaydocuments(waydocuments);
//			em.merge(way);
//			
//			waydocuments = d.getWaydocuments();
//			waydocuments.add(wd);
//			d.setWaydocuments(waydocuments);
//			em.merge(d);
//			
//			id_wayDoc = wd.getId();
//			
//		}
//		
//			return id_wayDoc;
//			
//	}

	
			


}
