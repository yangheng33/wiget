package com.amar.constant;

public class ProjectInfo
{
	public static final String name = "projectInfo";

	public String IP = "localhost";

	public String PORT = "80";

	public String PROTOCOL = "http";

	public String PROJECTNAME = "myspring";

	public String JMS_IP = "192.168.8.186";

	public String JMS_PORT = "61616";

	public String datadir;

	public String smtp;
	
	public String pop3;
	
	public String managerMail;
	
	public String managerMailPw;
	
	public String getIP()
	{
		return IP;
	}

	public void setIP( String iP )
	{
		IP = iP;
	}

	public String getPORT()
	{
		return PORT;
	}

	public void setPORT( String pORT )
	{
		PORT = pORT;
	}

	public String getPROTOCOL()
	{
		return PROTOCOL;
	}

	public void setPROTOCOL( String pROTOCOL )
	{
		PROTOCOL = pROTOCOL;
	}

	public String getPROJECTNAME()
	{
		return PROJECTNAME;
	}

	public void setPROJECTNAME( String pROJECTNAME )
	{
		PROJECTNAME = pROJECTNAME;
	}

	public String getJMS_IP()
	{
		return JMS_IP;
	}

	public void setJMS_IP( String jMS_IP )
	{
		JMS_IP = jMS_IP;
	}

	public String getJMS_PORT()
	{
		return JMS_PORT;
	}

	public void setJMS_PORT( String jMS_PORT )
	{
		JMS_PORT = jMS_PORT;
	}

	public String getDatadir()
	{
		return datadir;
	}

	public void setDatadir( String datadir )
	{
		this.datadir = datadir;
	}

	public String webBaseAddress()
	{
		return PROTOCOL + "://" + IP + ":" + PORT + "/" + PROJECTNAME;
	}

	public String jmsAddress()
	{
		return "tcp://" + JMS_IP + ":" + JMS_PORT;
	}

	public String getSmtp()
	{
		return smtp;
	}

	public void setSmtp( String smtp )
	{
		this.smtp = smtp;
	}

	public String getPop3()
	{
		return pop3;
	}

	public void setPop3( String pop3 )
	{
		this.pop3 = pop3;
	}

	public String getManagerMail()
	{
		return managerMail;
	}

	public void setManagerMail( String managerMail )
	{
		this.managerMail = managerMail;
	}

	public String getManagerMailPw()
	{
		return managerMailPw;
	}

	public void setManagerMailPw( String managerMailPw )
	{
		this.managerMailPw = managerMailPw;
	}
}
