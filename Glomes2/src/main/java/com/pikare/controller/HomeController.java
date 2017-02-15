package com.pikare.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;






import com.pikare.dao.MessageImp;
import com.pikare.dao.UserDao;
import com.pikare.dao.login.LoginDao;
import com.pikare.dao.login.LoginDaoImpl;
import com.pikare.model.MessageInfo;
import com.pikare.model.MessageSenders;
import com.pikare.model.UserRole;
import com.pikare.model.Users;
import com.pikare.session.PikareSession;

@Controller
public class HomeController {
	

	
	@Autowired
	UserDao userDao;

	@Autowired
	PikareSession pikareSession;

	@Autowired
	LoginDaoImpl loginDao;
	
	@Autowired
	MessageImp messageDao;
	
	
	
	private static final Logger logger = Logger.getLogger(HomeController.class); 
	
	@Autowired
	private SimpMessagingTemplate template;

//      public HomeController(SimpMessagingTemplate template) {
//          this.template = template;
//      }
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	ModelAndView giris()
	{
		logger.info(" project started");
		return new ModelAndView("/login/login");
	}
	
	@RequestMapping(value = "/secure/history", method = RequestMethod.GET)
	ModelAndView history()
	{
		ModelAndView view = new ModelAndView("history");
		List<MessageSenders> senders = messageDao.getAll();
		view.addObject("messages", senders);
		
		
		return view;
	}
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	ModelAndView giris2()
//	{
//		return new ModelAndView("/login/login");
//	}
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login2(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		
		ModelAndView model = new ModelAndView("/login/login");
		if (error != null) {
			model.addObject("error", "Kullanıc Adı yada şifre hatalı!");
		}

		if (logout != null) {
			model.addObject("msg", "Başarılı bir şekilde çıkış yapıldı.");
		}

		return model;

	}


	@RequestMapping(value = "/secure/newUser", method = RequestMethod.GET)
	ModelAndView newUser()
	{
		ModelAndView model = new ModelAndView("registerNewUser"); 
		
		Users user = new Users();
		
		model.addObject("user", user);
		model.addObject("saveorupdate","new");
		return model;
	}
	
	@RequestMapping(value = "/secure/listUser", method = RequestMethod.GET)
	ModelAndView userList()
	{
		ModelAndView model = new ModelAndView("userList");	
		List<Users> users = userDao.getAllUser();
		model.addObject("userList", users);
		return model;
	}
	
	
	
	@RequestMapping(value = "/secure/userUpdate", method = RequestMethod.GET)
	ModelAndView newUser2(@RequestParam(value = "username") String username)
	{
		ModelAndView model = new ModelAndView("registerNewUser");
		List<Users> users = userDao.getAllUser();
		Users user = loginDao.findByUserName(username);
		
		//get User roles and set
		for(int i = 0; i< user.getUserRole().size();i++)
			user.getRoles().add(user.getUserRole().get(i).getRole());
		//
		model.addObject("userList", users);
		model.addObject("user", user);
		model.addObject("saveorupdate","update");
		return model;
	}
	
	
	@RequestMapping(value = "/secure/newUser", method = RequestMethod.POST)
	ModelAndView newUserPost(@ModelAttribute(value="user") Users user)
	{
		ModelAndView model = new ModelAndView("registerNewUser");
	
		
		
		for(int i = 0; i<user.getRoles().size();i++)
			user.getUserRole().add(new UserRole(user,user.getRoles().get(i)));
		
		//get User roles and set

		if(user.getId() <= 0)
		{
			userDao.register(user);
			model.addObject("msg", "başarılı bir şekilde kayıt edildi. ");
			model.addObject("saveorupdate","new");
		}
		else
		{
			userDao.update(user);
			model.addObject("msg", "başarılı bir şekilde kayıt edildi. ");
			model.addObject("saveorupdate","update");
		}
		return model;
	}
	
	@RequestMapping(value="/secure/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
	
	
	@RequestMapping(value = "/secure/home2", method = RequestMethod.GET)
    public ModelAndView controllerMethod(@RequestParam("taskWeek") String week,
    		@RequestParam("taskSahibi") String user,
    		@RequestParam(value = "kategori" , defaultValue ="" ) String kategori,
    		@RequestParam("anakategori") String anakategori,
    		@RequestParam("status" ) String status,
    		@RequestParam(value= "firstdate" , defaultValue ="") String firstdate,
    		@RequestParam(value= "lastdate" , defaultValue ="") String lastdate
)
	{	
	
		ModelAndView model2 = new ModelAndView("home");
		
		
		return model2;
	}
	@RequestMapping(value = "secure/dialogs", method = RequestMethod.GET)
	public ModelAndView dialogs() {
		setSession();
		
		ModelAndView view = new ModelAndView("dialogs");
		view.addObject("repID", pikareSession.getRepID());
		return 	view;
	}
	
	@RequestMapping(value = "secure/chats", method = RequestMethod.GET)
	public ModelAndView chat() {
		setSession();
		
		ModelAndView view = new ModelAndView("chats");
		view.addObject("repID", pikareSession.getRepID());
		return 	view;
	}
	
	@RequestMapping(value = "secure/getUser", method = RequestMethod.GET)
	public @ResponseBody Users getUser() {
		setSession();
		if(pikareSession.getUsername().isEmpty())
			return null;
		else
		{
			return userDao.getUser(pikareSession.getUsername());
		}
	}
	
	
	@RequestMapping(value="/fb/recieveMessage", method=RequestMethod.GET)  
    public @ResponseBody String recieveMessage(@RequestParam(value = "messageid") String messageId, 
			@RequestParam(value = "messageText") String messageText,
			@RequestParam(value = "senderId") String senderId,
			@RequestParam(value = "recipientId") String recipientId,
			@RequestParam(value = "name") String name
			) throws Exception {
		
		logger.info(messageText +","+ recipientId +","+senderId);
		String messageText2 = URLDecoder.decode(messageText,"UTF-8");
		logger.info("url encode " + messageText);
		
		MessageSenders message = new MessageSenders();
		message.setRepID(recipientId);
		message.setSenderID(senderId);
		
		message.setSenderName(name);
			
		MessageInfo info = new MessageInfo();
		info.setMessageID(messageId);
		info.setMessageTxt(messageText);
		info.setSender(message);	
		info.setMessageSide("left");
		message.getMessage().add(info);
		
		
		message = messageDao.save(message);
		
		String user = "";
		if(message.getUserName() == null)
			user = "yeni";
		else if(message.getUserName().isEmpty())
		{
			user = "yeni";
		}
		
        this.template.convertAndSend("/fb/topic/greetings", messageText +","+ recipientId +","+senderId+','+""+','+name+","+user );
        System.out.println("naberlennn");
        return "1";
    } 
	
	
	@RequestMapping(value="/secure/getAllMessage", method=RequestMethod.GET)  
	public @ResponseBody List<MessageSenders> sendMessages()
	{
		List<MessageSenders> list = messageDao.getAll();
		return list;	
	}
	
	
	
	@RequestMapping(value = "/fb/sendMessage" , method = RequestMethod.GET)
	public @ResponseBody String sendMessages(
			@RequestParam(value="messageText") String msg ,
			@RequestParam(value="senderId") String senderId ,
			@RequestParam(value="recipientId") String recipientId 	
			) throws IOException {
		
		
		MessageSenders message = new MessageSenders();
		message.setRepID(recipientId);
		message.setSenderID(senderId);
		
		
		
		MessageInfo info = new MessageInfo();
		info.setMessageTxt(msg);
		info.setSender(message);	
		info.setMessageSide("right");
		message.getMessage().add(info);
		
		messageDao.save(message);
		
		String getUrl ="https://hidden-beyond-25005.herokuapp.com/fb/sendTextMessage?";
		//String tmp = URLDecoder.decode(msg, "UTF 8");
		msg.toUpperCase();
		msg = URLEncoder.encode(msg,"UTF-8");
		
		getUrl += "receiptId="+recipientId+"&message="+msg+"&senderId="+senderId;
		String encodedURL=java.net.URLEncoder.encode(getUrl,"UTF-8");
		
		logger.info("giden url" + getUrl);
		logger.info("giden url encode" + encodedURL);
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(((HttpURLConnection) (new URL(getUrl)).openConnection()).getInputStream(), Charset.forName("UTF-8")));
		
		String inputLine , response ="";
		while ((inputLine = reader.readLine()) != null) {
			response += inputLine; 
		}
		
//		URL obj = new URL(getUrl);
//		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//		con.setRequestMethod("GET");
//		con.setRequestProperty("User-Agent", "Mozilla/5.0");
//		int responseCode = con.getResponseCode();
//		System.out.println("GET Response Code :: " + responseCode);
	    
//		if (responseCode == HttpURLConnection.HTTP_OK)
//		{
//			return "true";
//		}
//		else
		
		if(response.equals("1"))
			return "true";
		else
			return "false";
		
	}
		
		@RequestMapping(value = "secure/changePassword", method = RequestMethod.GET)
		public ModelAndView changePassword() {
			
			return new ModelAndView("changePass");	
		}
		
		@RequestMapping(value = "secure/index", method = RequestMethod.GET)
		public ModelAndView index() {
			
			return new ModelAndView("index");	
		}
		
		@RequestMapping(value = "secure/changePass", method = RequestMethod.POST)
		public ModelAndView changePass(@RequestParam(value = "changePass") String pass,final RedirectAttributes redirectAttributes) {
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();			
			userDao.changePassword(auth.getName(), pass);
			redirectAttributes.addFlashAttribute("msg", "şifreniz degiştirilmiştir");
			ModelAndView model = new ModelAndView("redirect:changePassword");
			model.addObject("msg", "şifreniz degiştirilmiştir");
			return model;
		}
		
		
	
		@RequestMapping(value = "secure/home", method = RequestMethod.GET)
		public ModelAndView deneme() {
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			
			Users user = userDao.getUser(auth.getName());
			
			setSession();
			
			ModelAndView model2 = new ModelAndView("home");	
			model2.addObject("repID" , user.getRepID());
			model2.addObject("user" , user);
			
			return model2;
		}
		
		@RequestMapping(value = "secure/agentInfo", method = RequestMethod.GET)
		public ModelAndView agentInfo() {
			
			setSession();
			
			ModelAndView model2 = new ModelAndView("agentInfo");	
			
			return model2;
		}
		
		
		@RequestMapping(value = "secure/KonusmayaBasla", method = RequestMethod.GET)
		public @ResponseBody MessageSenders KonusmayaBasla(@RequestParam(value="senderId") String senderId , 
				@RequestParam(value="recipientId") String recipientId) {
			
			setSession();
			String user = pikareSession.getUsername();
			
			MessageSenders sender = messageDao.getBySenderID(senderId, recipientId);
			sender.setUserName(user);
			
			if(messageDao.update(sender))
			{
				return sender;
				
			}
			else
				return null;
			
		}
		
		void setSession()
		{
			if(pikareSession.getUsername().isEmpty())
			{
				Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			    String name = auth.getName(); //get logged in username
			    Users user = loginDao.findByUserName(name);
			    
			    pikareSession.setName(user.getName());
				pikareSession.setSurname(user.getSurname());
				pikareSession.setUsername(user.getUsername());
				pikareSession.setRole(user.getUserRole().get(0).getRole());
				pikareSession.setRepID(user.getRepID());
			}
		}
		
//		public static String GetEncodedUrlForTurkishCharacters(String textToEncode) {
//		    String temp = textToEncode;
//		 
//		    for (int i = 0; i < temp.length(); i++) {
//		        if (temp[i] == 'ç') {
//		            temp = temp.Replace("ç", "%C3%A7");
//		        } else if (temp[i] == 'Ç') {
//		            temp = temp.Replace("Ç", "%C3%87");
//		        } else if (temp[i] == 'ğ') {
//		            temp = temp.Replace("ğ", "%C4%9F");
//		        } else if (temp[i] == 'Ğ') {
//		            temp = temp.Replace("Ğ", "%C4%9E");
//		        } else if (temp[i] == 'ı') {
//		            temp = temp.Replace("ı", "%C4%B1");
//		        } else if (temp[i] == 'İ') {
//		            temp = temp.Replace("İ", "%C4%B0");
//		        } else if (temp[i] == 'ö') {
//		            temp = temp.Replace("ö", "%C3%B6");
//		        } else if (temp[i] == 'Ö') {
//		            temp = temp.Replace("Ö", "%C3%96");
//		        } else if (temp[i] == 'ş') {
//		            temp = temp.Replace("ş", "%C5%9F");
//		        } else if (temp[i] == 'Ş') {
//		            temp = temp.Replace("Ş", "%C5%9E");
//		        } else if (temp[i] == 'ü') {
//		            temp = temp.Replace("ü", "%C3%BC");
//		        } else if (temp[i] == 'Ü') {
//		            temp = temp.Replace("Ü", "%C3%9C");
//		        }
//		    }
//		 
//		    return temp;
//		}
}

