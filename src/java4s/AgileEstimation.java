package java4s;

import javax.servlet.http.*;
import java.io.*;
import java.lang.String;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Calendar;
import java.util.Date;

public class AgileEstimation extends HttpServlet
{
	Boolean passorfail;
	String UserName = "null";
	String Password = "null";
	
//	Date today = new Date(); // Fri Jun 17 14:54:28 PDT 2016 
	Calendar cal = Calendar.getInstance();

	int year = cal.get(Calendar.YEAR);

	private static final String FILENAME = "D:\\Sreenivas_Do_Not_Delete\\TestEstimationData.txt";
	
	BufferedWriter bw = null;
	FileWriter fw = null;
	
	
	
	public void updateFile(String estimation_data) 
	{
		try {
			String content = estimation_data;
			fw = new FileWriter(FILENAME, true);
			bw = new BufferedWriter(fw);
			bw.write(content);
			bw.newLine();
			bw.newLine();

//			System.out.println("Written to file Success");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {
			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();
			}
		}    
	}

	
	public Boolean authentication(String username, String password) 
	{ 

		// BU = ACES or FS or etc.
		// BU Type = INS or BAN or CoE or etc.
		// Client Name = ANZ or RBS or UTO or etc.
		// Project Name = ABCD or XYZ or CoE or etc.
		// Initiators Name = Ravi, John, etc
	
	        switch (username) {
	            case "FS_UTO_CoE_Sreenivas":
	            			if (year<=2018)
	            			passorfail=password.equals("q2m!x:dCk6FaG$Ec");
	         				break;
	//            case "FS_BAN_ANZ_DIGITAL_GANESH":  
	//		    			passorfail=password.equals("q`r^8{De,Sn*!KU_");
	//		 				break;		 				
	            default: 
							passorfail = false;          
							break;  		 
		}
		return passorfail;

	}
		

	
	public double clarityfamiliaritylevel(String clarityfamiliaritystr) 
	{ 
		double clarityfamiliarityvalue = 0;
        switch (clarityfamiliaritystr) {
            case "Complete":  clarityfamiliarityvalue = 1;
                     break;
            case "High":  clarityfamiliarityvalue = 1.01;          
                     break;
            case "Medium":  clarityfamiliarityvalue = 1.03;          
            		 break;
            case "Low":  clarityfamiliarityvalue = 1.05;           
            		 break;
            default: break;
        }    
		 return clarityfamiliarityvalue;
	}

	public double complixityverificationlevel(String complixityverificationstr) 
	{ 
		double complixityverification = 0;
        switch (complixityverificationstr) {
            case "Simple":  complixityverification = 0.95;
                     break;
            case "Medium":  complixityverification = 1;          
                     break;
            case "Complex":  complixityverification = 1.05;          
            		 break;
            default: break;
        }    
		 return complixityverification;
	}
	
    @Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) 
    {
   	try
     {
		String UserName=req.getParameter("username");
		String Password=req.getParameter("password");
		String TechnologyUsed=req.getParameter("TechnologyUsed");
		String DomainLevelComplexity=req.getParameter("DomainLevelComplexity");
		String Location=req.getParameter("Location");
		String ProgressionAutomationInfrastructureAvailablity=req.getParameter("ProgressionAutomationInfrastructureAvailablity");
		String RegressionAutomationInfrastructureAvailablity=req.getParameter("RegressionAutomationInfrastructureAvailablity");
		String Automation=req.getParameter("Automation");
		String DeploymentInfrastructureAutomated=req.getParameter("Build&DeploymentInfrastructureAutomated");		
		String TestManagement=req.getParameter("TestManagement");
		String TestData=req.getParameter("TestData");
		String TestEnvironment=req.getParameter("TestEnvironment");
		String refacNetworkConnectivitytoring=req.getParameter("NetworkConnectivity");
		String ProactiveMonitoring=req.getParameter("ProactiveMonitoring");	
		String SupportfromClientmanagement=req.getParameter("SupportfromClientmanagement");
		String SupportfromVendormanagement=req.getParameter("SupportfromVendormanagement");
		String ProductOrBusinessOwnersAvailability=req.getParameter("ProductOrBusinessOwnersAvailability");
		String AgileAwarenessProductOrBusinessOwners=req.getParameter("AgileAwarenessProductOrBusinessOwners");
		String SupportTeamsAvailability=req.getParameter("SupportTeamsAvailability");
		String OnsiteOrNearshoreCoordinatorsRoleResponsibilities=req.getParameter("OnsiteOrNearshoreCoordinatorsRoleResponsibilities");
		String ReadWriteAccess=req.getParameter("ReadWriteAccess");
		String DomainKnowledge=req.getParameter("DomainKnowledge");		
		String ReusabilityManualTests=req.getParameter("ReusabilityManualTests");
		String AgileAwarenessTesters=req.getParameter("AgileAwarenessTesters");
		String Collaboration=req.getParameter("Collaboration");
		String TurnAroundTime=req.getParameter("TurnAroundTime");
		String Refactoring=req.getParameter("Refactoring");
		String Cycles=req.getParameter("Cycles");		

	
		int extrasmalltestcases=Integer.valueOf(req.getParameter("extrasmalltestcases"));
		String extrasmallclarity=req.getParameter("extrasmallclarity");
		String extrasmallcomplexity=req.getParameter("extrasmallcomplexity");
		String extrasmallfamiliarity=req.getParameter("extrasmallfamiliarity");
		String extrasmallverification=req.getParameter("extrasmallverification");
		
		int smalltestcases=Integer.valueOf(req.getParameter("smalltestcases"));
		String smallclarity=req.getParameter("smallclarity");
		String smallcomplexity=req.getParameter("smallcomplexity");
		String smallfamiliarity=req.getParameter("smallfamiliarity");
		String smallverification=req.getParameter("smallverification");
		
		int mediumtestcases=Integer.valueOf(req.getParameter("mediumtestcases"));
		String mediumclarity=req.getParameter("mediumclarity");
		String mediumcomplexity=req.getParameter("mediumcomplexity");
		String mediumfamiliarity=req.getParameter("mediumfamiliarity");
		String mediumverification=req.getParameter("mediumverification");
		
		int largetestcases=Integer.valueOf(req.getParameter("largetestcases"));		
		String largeclarity=req.getParameter("largeclarity");
		String largecomplexity=req.getParameter("largecomplexity");
		String largefamiliarity=req.getParameter("largefamiliarity");
		String largeverification=req.getParameter("largeverification");
		
		int extralargetestcases=Integer.valueOf(req.getParameter("extralargetestcases"));
		String extralargeclarity=req.getParameter("extralargeclarity");
		String extralargecomplexity=req.getParameter("extralargecomplexity");
		String extralargefamiliarity=req.getParameter("extralargefamiliarity");
		String extralargeverification=req.getParameter("extralargeverification");
		
		int extrasmallnumber=Integer.valueOf(req.getParameter("extrasmallnumber"));
		int smallnumber=Integer.valueOf(req.getParameter("smallnumber"));
		int mediumnumber=Integer.valueOf(req.getParameter("mediumnumber"));
		int largenumber=Integer.valueOf(req.getParameter("largenumber"));
		int extralargenumber=Integer.valueOf(req.getParameter("extralargenumber"));
		
		res.setContentType("text/html");
     
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");		

		double projLevelAdjFactor = 0;

		double TechnologyUsedadjfactor = 0;
        switch (TechnologyUsed) {
            case "Java":  TechnologyUsedadjfactor = 0;
                     break;
            case "Legacy":  TechnologyUsedadjfactor = 10;
                     break;
            case "Packaged": TechnologyUsedadjfactor = 5;
                     break;
            case "Combination of all": TechnologyUsedadjfactor = 8;
            break;
            default: break;
        }        
//        System.out.println("Technology Used Adjustment Factor : " + TechnologyUsedadjfactor);
        
		
		double DomainLevelComplexityadjfactor = 0;
        switch (DomainLevelComplexity) {
            case "Simple":  DomainLevelComplexityadjfactor = 0.1;
                     break;
            case "Medium":  DomainLevelComplexityadjfactor = 0.15;
                     break;
            case "Complex": DomainLevelComplexityadjfactor = 0.225;
                     break;
            case "Too Complex": DomainLevelComplexityadjfactor = 0.3;
            break;
            default: break;
        }        
//      System.out.println("Domain Level Complexity Adjustment Factor : " + DomainLevelComplexityadjfactor);
        
		
        double locationfactor = 0;
        switch (Location) {
            case "Colocated":  locationfactor = 1.009;
                     break;
            case "Distributed":  locationfactor = 1.2;
                     break;
            default: break;
        }        
//        System.out.println("Location Adjustment Factor : " + locationfactor);
        
		
        double progressionautomationfactor = 0;
        switch (ProgressionAutomationInfrastructureAvailablity) {
            case "Yes":  progressionautomationfactor = 1.009;
                     break;
            case "No":  progressionautomationfactor = 1.018;
                     break;
            case "Not Applicable":  progressionautomationfactor = 1;
            break;
            default: break;
        }        
//        System.out.println("Progression Automation Adjustment Factor : " + progressionautomationfactor);
        

        double regressionautomationfactor = 0;
        switch (RegressionAutomationInfrastructureAvailablity) {
            case "Yes":  regressionautomationfactor = 1.009;
                     break;
            case "No":  regressionautomationfactor = 1.018;
                     break;
            default: break;
        }        
//        System.out.println("Regression Automation Adjustment Factor : " + regressionautomationfactor);

        
        double automationfactor = 0;
        switch (Automation) {
            case "No Automation Coverage":  automationfactor = 1.45;
                     break;
            case "~25% Automation Coverage":  automationfactor = 1.3;
                     break;
            case "50% Automation Coverage":  automationfactor = 1.2;
            		 break;
            case "~75% Automation Coverage":  automationfactor = 1.009;
            		 break;
            default: break;
        }        
//        System.out.println("Automation Coverage Adjustment Factor : " + automationfactor);
        
       
		double DeploymentInfrastructureAutomatedfactor = 0;
        switch (DeploymentInfrastructureAutomated) {
            case "Semi Automated":  DeploymentInfrastructureAutomatedfactor = 1.018;
                     break;
            case "Fully Automated":  DeploymentInfrastructureAutomatedfactor = 1.009;
            		 break;
            case "Fully Manual":  DeploymentInfrastructureAutomatedfactor = 1.036;
            		 break;
            default: break;
        }        
//        System.out.println("Deployment Infrastructure Adjustment Factor : " + DeploymentInfrastructureAutomatedfactor);


		double testmanagementfactor = 0;
        switch (TestManagement) {
            case "High":  testmanagementfactor = 1.036;
                     break;
            case "Medium":  testmanagementfactor = 1.018;
                     break;
            case "Low":  testmanagementfactor = 1.009;
            break;

            default: break;
        }        
//        System.out.println("Test Management Adjustment Factor : " + testmanagementfactor);
        

		double testdatafactor = 0;
        switch (TestData) {
            case "High":  testdatafactor = 1.036;
                     break;
            case "Medium":  testdatafactor = 1.018;
                     break;
            case "Low":  testdatafactor = 1.009;
            break;

            default: break;
        }        
//        System.out.println("Test Data Adjustment Factor : " + testdatafactor);


		double testenvironmentfactor = 0;
        switch (TestEnvironment) {
            case "High":  testenvironmentfactor = 1.036;
                     break;
            case "Medium":  testenvironmentfactor = 1.018;
                     break;
            case "Low":  testenvironmentfactor = 1.009;
            		 break;
            default: break;
        }        
//        System.out.println("Test Environment Adjustment Factor : " + testenvironmentfactor);


		double NetworkConnectivityfactor = 0;
        switch (refacNetworkConnectivitytoring) {
            case "Excellent":  NetworkConnectivityfactor = 1.009;
                     break;
            case "Good":  NetworkConnectivityfactor = 1.018;
                     break;
            case "Average":  NetworkConnectivityfactor = 1.036;
            		 break;
            default: break;
        }        
//        System.out.println("Network Connectivity Adjustment Factor : " + NetworkConnectivityfactor);
        
		double ProactiveMonitoringfactor = 0;
        switch (ProactiveMonitoring) {
            case "Highly Available":  ProactiveMonitoringfactor = 1.009;
                     break;
            case "Available":  ProactiveMonitoringfactor = 1.018;
                     break;
            case "Highly Unavailable": ProactiveMonitoringfactor = 1.036;
                     break;
            case "Not Applicable": ProactiveMonitoringfactor = 1;
            		 break;
            default: break;
        }        
//        System.out.println("Proactive Monitoring Adjustment Factor : " + ProactiveMonitoringfactor);
        

		double SupportfromClientmanagementfactor = 0;
        switch (SupportfromClientmanagement) {
            case "High":  SupportfromClientmanagementfactor = 1.009;
                     break;
            case "Medium":  SupportfromClientmanagementfactor = 1.018;
                     break;
            case "Low": SupportfromClientmanagementfactor = 1.036;
                     break;
            case "Not Applicable": SupportfromClientmanagementfactor = 1;
            		 break;
            default: break;
        }        
//        System.out.println("Support From Client Mmanagement Adjustment Factor : " + SupportfromClientmanagementfactor);


		double SupportfromVendormanagementfactor = 0;
        switch (SupportfromVendormanagement) {
            case "Highly Available":  SupportfromVendormanagementfactor = 1.009;
                     break;
            case "Available":  SupportfromVendormanagementfactor = 1.018;
                     break;
            case "Highly Unavailable": SupportfromVendormanagementfactor = 1.036;
                     break;
            case "Not Applicable": SupportfromVendormanagementfactor = 1;
            break;
            default: break;
        }        
//        System.out.println("Support From Vendor Management Adjustment Factor : " + SupportfromVendormanagementfactor);
        
       
		double ProductOrBusinessOwnersAvailabilityfactor = 0;
        switch (ProductOrBusinessOwnersAvailability) {
            case "Highly Available":  ProductOrBusinessOwnersAvailabilityfactor = 1.009;
                     break;
            case "Available":  ProductOrBusinessOwnersAvailabilityfactor = 1.018;
                     break;
            case "Highly Unavailable":  ProductOrBusinessOwnersAvailabilityfactor = 1.036;
            		 break;
            default: break;
        }        
//        System.out.println("Product Or Business Owners Availability Adjustment Factor : " + ProductOrBusinessOwnersAvailabilityfactor);


		double AgileAwarenessProductOrBusinessOwnersfactor = 0;
        switch (AgileAwarenessProductOrBusinessOwners) {
            case "AwareOf Agile Principles & Practices":  AgileAwarenessProductOrBusinessOwnersfactor = 1.009;
                     break;
            case "UnAwareOf Agile Principles & Practices":  AgileAwarenessProductOrBusinessOwnersfactor = 1.018;
                     break;
            default: break;
        }        
//        System.out.println("Agile Awareness Product Or Business Owners Adjustment Factor : " + AgileAwarenessProductOrBusinessOwnersfactor);

        
		double SupportTeamsAvailabilityfactor = 0;
        switch (SupportTeamsAvailability) {
            case "High":  SupportTeamsAvailabilityfactor = 1.009;
                     break;
            case "Medium":  SupportTeamsAvailabilityfactor = 1.018;
                     break;
            case "Low":  SupportTeamsAvailabilityfactor = 1.036;
            		 break;
            case "Not Applicable":  SupportTeamsAvailabilityfactor = 1;
            		 break;
            default: break;
        }        
//        System.out.println("Support Teams Availability Adjustment Factor : " + SupportTeamsAvailabilityfactor);


        double OnsiteOrNearshoreCoordinatorsRoleResponsibilitiesfactor = 0;
        switch (OnsiteOrNearshoreCoordinatorsRoleResponsibilities) {
            case "High":  OnsiteOrNearshoreCoordinatorsRoleResponsibilitiesfactor = 1; // 1.009
                     break;
            case "Medium":  OnsiteOrNearshoreCoordinatorsRoleResponsibilitiesfactor = 1.018;
                     break;
            case "Low":  OnsiteOrNearshoreCoordinatorsRoleResponsibilitiesfactor = 1.036;
            		 break;
            default: break;
        }        
//        System.out.println("Onsite Or Nearshore Coordinators Role and Responsibilities Adjustment Factor : " + OnsiteOrNearshoreCoordinatorsRoleResponsibilitiesfactor);


        double ReadWriteAccessfactor = 0;
        switch (ReadWriteAccess) {
            case "Yes":  ReadWriteAccessfactor = 1.009;
                     break;
            case "No":  ReadWriteAccessfactor = 1.018;
                     break;
            case "Not Applicable":  ReadWriteAccessfactor = 1;
            		 break;
            default: break;
        }        
//        System.out.println("Read Write Access Adjustment Factor : " + ReadWriteAccessfactor);


		double DomainKnowledgefactor = 0;
        switch (DomainKnowledge) {
            case "High":  DomainKnowledgefactor = 1.009;
                     break;
            case "Medium":  DomainKnowledgefactor = 1.018;
                     break;
            case "Low":  DomainKnowledgefactor = 1.036;
            break;

            default: break;
        }        
//        System.out.println("Domain Knowledge Adjustment Factor : " + DomainKnowledgefactor);


        double ReusabilityManualTestsfactor = 0;
        switch (ReusabilityManualTests) {
            case "High":  ReusabilityManualTestsfactor = 1.009;
                     break;
            case "Medium":  ReusabilityManualTestsfactor = 1.018;
                     break;
            case "Low":  ReusabilityManualTestsfactor = 1.036;
            break;

            default: break;
        }        
//        System.out.println("Reusability Manual Tests Adjustment Factor : " + ReusabilityManualTestsfactor);

        
		double AgileAwarenessTestersfactor = 0;
        switch (AgileAwarenessTesters) {
            case "Less than 25% trained on Agile":  AgileAwarenessTestersfactor = 1.009;
                     break;
            case "Around 50% trained on Agile":  AgileAwarenessTestersfactor = 1.018;
                     break;
            case "More than 75% trained on Agile":  AgileAwarenessTestersfactor = 1.018;
            		 break;
            default: break;
        }        
//        System.out.println("Agile Awareness Testers Adjustment Factor : " + AgileAwarenessTestersfactor);
        

        double Collaborationfactor = 0;
        switch (Collaboration) {
            case "High":  Collaborationfactor = 1.018;
                     break;
            case "Medium":  Collaborationfactor = 1.036;
                     break;
            case "Low":  Collaborationfactor = 1.054;
            break;

            default: break;
        }        
//        System.out.println("Collaboration Adjustment Factor : " + Collaborationfactor);
		
       
		double TurnAroundTimefactor = 0;
        switch (TurnAroundTime) {
            case "High":  TurnAroundTimefactor = 1.036;
                     break;
            case "Medium":  TurnAroundTimefactor = 1.018;
                     break;
            case "Low":  TurnAroundTimefactor = 1.009;
            		 break;
            default: break;
        }        
//        System.out.println("Turn Around Time Adjustment Factor : " + TurnAroundTimefactor);


		double Refactoringfactor = 0;
        switch (Refactoring) {
            case "High":  Refactoringfactor = 1.036;
                     break;
            case "Medium":  Refactoringfactor = 1.018;
                     break;
            case "Low":  Refactoringfactor = 1.009;
            		 break;
            default: break;
        }        
//        System.out.println("Refactoring Adjustment Factor : " + Refactoringfactor);

        
		double cyclesfactor = 0;
        switch (Cycles) {
            case "1 Round of Testing":  cyclesfactor = 1.018;
                     break;
            case "2 Rounds of Testing":  cyclesfactor = 1.036;
                     break;
            default: break;
        }        
//        System.out.println("cycles Adjustment Factor : " + cyclesfactor);
        
        projLevelAdjFactor = progressionautomationfactor*regressionautomationfactor*automationfactor*DeploymentInfrastructureAutomatedfactor*testmanagementfactor*testdatafactor*testenvironmentfactor*NetworkConnectivityfactor*ProactiveMonitoringfactor*SupportfromClientmanagementfactor*SupportfromVendormanagementfactor*ProductOrBusinessOwnersAvailabilityfactor*AgileAwarenessProductOrBusinessOwnersfactor*SupportTeamsAvailabilityfactor*OnsiteOrNearshoreCoordinatorsRoleResponsibilitiesfactor*ReadWriteAccessfactor*DomainKnowledgefactor*locationfactor*AgileAwarenessTestersfactor*Collaborationfactor*TurnAroundTimefactor*Refactoringfactor*cyclesfactor*ReusabilityManualTestsfactor;
//        System.out.println("Project Level Adjustment Factor" + projLevelAdjFactor);
        
        if (authentication(UserName,Password))
        {
		
//    		System.out.println("User Name : " + UserName);
//    		System.out.println("Password : " + Password);
    		
	        pw.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Transitional//EN'><HTML><HEAD><TITLE> Test Effort Calculation </TITLE>");
			pw.println("<META NAME='Generator' CONTENT='EditPlus'><META NAME='Author' CONTENT=''><META NAME='Keywords' CONTENT=''>");
			pw.println("<META NAME='Description' CONTENT=''> </HEAD> <BODY bgcolor='#E6E6FA'><center><font face='Times New Roman' size='5' color='#000080'>");
			pw.println("<b> Agile Test Estimation (Results) </b></font></center>");
			pw.println("<center><font face='Times New Roman' size='1' color='#000080'><b> <I>[Researched & Developed (R&D) By Mothukuru Sreenivas, AgileCoE/UTO] </I></b></font></center><hr size='1' color='#008000'>");
	        	
			pw.println("<b><p><font face='Arial' color='#008000'>Project Level Adjustment Factors:</font></p>");
			pw.println("<TABLE><TR><TD><font color=''>Technology Used</TD>");	 
			pw.println("<TD>" + TechnologyUsed + "</font></TD></TR>");
			
			pw.println("<TR><TD><font color=''>Domain Level Complexity</TD>");
			pw.println("<TD>" + DomainLevelComplexity + "</font></TD></TR>");
	
			pw.println("<TR><TD><font color=''>Are Teams Co-located?</TD>");	 
			pw.println("<TD>" + Location + "</font></TD></TR>");
			
			pw.println("<TR><TD><font color=''>Is Progression automation infrastructure available?</TD>");	 
			pw.println("<TD>" + ProgressionAutomationInfrastructureAvailablity + "</font></TD></TR>");
	
			pw.println("<TR><TD><font color=''>Is Regression automation infrastructure available?</TD>");	 
			pw.println("<TD>" + RegressionAutomationInfrastructureAvailablity + "</font></TD></TR>");
	
			pw.println("<TR><TD><font color=''>Availability of Pre-Scripted Automated Regression Test Suites (i.e. Automation Test Coverage)?</TD>");	 
			pw.println("<TD>" + Automation + "</font></TD></TR>");
	
			pw.println("<TR><TD><font color=''>Is Build & Deployment infrastructure Automated?</TD>");	 
			pw.println("<TD>" + DeploymentInfrastructureAutomated + "</font></TD></TR>");
	
			pw.println("<TR><TD><font color=''>Test Management Effort (Scrum Master, PM, Proxy Scrum Master, Proxy PM)?</TD>");	 
			pw.println("<TD>" + TestManagement + "</font></TD></TR>");
	
			pw.println("<TR><TD><font color=''>Test Data Preparation Effort or Documentation Preparation Effort?</TD>");	 
			pw.println("<TD>" + TestData + "</font></TD></TR>");
	
			pw.println("<TR><TD><font color=''>Test Environment Preparation Effort (which includes Continuous Integration)?</TD>");	 
			pw.println("<TD>" + TestEnvironment + "</font></TD></TR>");
	
			pw.println("<TR><TD><font color=''>Network Connectivity?</TD>");	 
			pw.println("<TD>" + refacNetworkConnectivitytoring + "</font></TD></TR>");
	
			pw.println("<TR><TD><font color=''>Pro-active monitoring / health check system infrastructure availability?</TD>");	 
			pw.println("<TD>" + ProactiveMonitoring + "</font></TD></TR>");
	
			pw.println("<TR><TD><font color=''>Support from Client management</TD>");	 
			pw.println("<TD>" + SupportfromClientmanagement + "</font></TD></TR>");
	
			pw.println("<TR><TD><font color=''>Support from Vendor management</TD>");	 
			pw.println("<TD>" + SupportfromVendormanagement + "</font></TD></TR>");
	
			pw.println("<TR><TD><font color=''>Product / Business Owner's availability</TD>");	 
			pw.println("<TD>" + ProductOrBusinessOwnersAvailability + "</font></TD></TR>");
	
			pw.println("<TR><TD><font color=''>Agile awareness (trained on Agile) - Product/Business Owners</TD>");	 
			pw.println("<TD>" + AgileAwarenessProductOrBusinessOwners + "</font></TD></TR>");
	
			pw.println("<TR><TD><font color=''>Support team's availability</TD>");	 
			pw.println("<TD>" + SupportTeamsAvailability + "</font></TD></TR>");
	
			pw.println("<TR><TD><font color=''>Onsite/Nearshore Coordinator's Role & Responsibilities?</TD>");	 
			pw.println("<TD>" + OnsiteOrNearshoreCoordinatorsRoleResponsibilities + "</font></TD></TR>");
	
			pw.println("<TR><TD><font color=''>Does the Testers have Read (/Write) access to core systems (i.e. Servers, Source Code, Database, etc)?</TD>");	 
			pw.println("<TD>" + ReadWriteAccess + "</font></TD></TR>");
	
			pw.println("<TR><TD><font color=''>Teams Domain Knowledge?</TD>");	 
			pw.println("<TD>" + DomainKnowledge + "</font></TD></TR>");
	
			pw.println("<TR><TD><font color=''>Level of re-usability of manual tests in subsequent sprints?</TD>");	 
			pw.println("<TD>" + ReusabilityManualTests + "</font></TD></TR>");
	
			pw.println("<TR><TD><font color=''>Agile awareness (trained on Agile) - Testers</TD>");	 
			pw.println("<TD>" + AgileAwarenessTesters + "</font></TD></TR>");
	
			pw.println("<TR><TD><font color=''>Collaboration with Customers, Receptivity for Feedback (Stand-Up, Retrospective, Customer Feedback), Approval Process</TD>");	 
			pw.println("<TD>" + Collaboration + "</font></TD></TR>");
	
			pw.println("<TR><TD><font color=''>Defect Turnaround Time (Dependencies with Dev & Environment Issues)?</TD>");	 
			pw.println("<TD>" + TurnAroundTime + "</font></TD></TR>");
	
			pw.println("<TR><TD><font color=''>Requirement Refactoring & Story Setback?</TD>");	 
			pw.println("<TD>" + Refactoring + "</font></TD></TR>");
	
			pw.println("<TR><TD><font color=''>Testing Cycles (1 or 2 rounds of testing)?</TD>");	 
			pw.println("<TD>" + Cycles + "</font></TD></TR></TABLE><HR>");
					
			pw.println("<b><p><font face='Arial' color='#008000'>Scenario Level Adjustment Factors:</font></p>");
			pw.println("<TABLE border='2' cellspacing='value' cellpadding='2' rules='all'><TR>");
			pw.println("<TD width='15%' align='center'><font color='Brown'><B>User Story Type</B></Font></TD>");
			pw.println("<TD width='15%' align='center'><font color='Brown'><B>No. of Test Cases</B></Font></TD>");
	//		pw.println("<TD width='15%' align='center'><font color='Brown'><B>No. of Raw Test Steps</B></Font></TD>");
			pw.println("<TD width='10%' align='center'><font color='Brown'><B>User Story Clarity</B></Font></TD>");
			pw.println("<TD width='10%' align='center'><font color='Brown'><B>Functional Complexity</B></Font></TD>");
			pw.println("<TD width='10%' align='center'><font color='Brown'><B>Familiarity Level</B></Font></TD>");
			pw.println("<TD width='10%' align='center'><font color='Brown'><B>Verification Type</B></Font></TD>");
	//		pw.println("<TD width='150%' align='center'><font color='Brown'><B>TSP</B></Font></TD></TR>");
			pw.println("</TR>");
			
			pw.println("<TR><TD width='15%'><Center>Extra Small</Center></TD><TD width='15%'><Center> " + extrasmalltestcases + "</Center></TD>");
	//		pw.println("<TD width='15%' align='center'> " + extrasmalltestcases*3 + " </Font></TD>");
			pw.println("<TD width='10%'><Center> " + extrasmallclarity + " </Center></TD><TD width='10%'><Center> " + extrasmallcomplexity + " </Center></TD>");
			pw.println("<TD width='10%'><Center> " + extrasmallfamiliarity + " </Center></TD><TD width='10%'><Center> " + extrasmallverification + " </Center></TD>");
			double extrasmalltcp = clarityfamiliaritylevel(extrasmallclarity)*complixityverificationlevel(extrasmallcomplexity)*clarityfamiliaritylevel(extrasmallfamiliarity)*complixityverificationlevel(extrasmallverification)*(extrasmalltestcases*3)*projLevelAdjFactor;
	//		pw.println("<TD width='15%' align='center'><font color='Brown'><B> " + Math.round(extrasmalltcp) + " </B></Font></TD></TR>");
			pw.println("</TR>");
			
//			System.out.println("No. of Extra Small Test Cases : " + extrasmalltestcases);
//			System.out.println("Clarity of Extra Small User Stories : " + extrasmallclarity);
//			System.out.println("Complexity of Extra Small User Stories : " + extrasmallcomplexity);
//			System.out.println("Familiarity of Extra Small User Stories : " + extrasmallfamiliarity);
//			System.out.println("Verification of Extra Small User Stories : " + extrasmallverification);
			
			pw.println("<TR><TD width='15%'><Center>Small</Center></TD><TD width='15%'><Center> " + smalltestcases + " </Center></TD>");
	//		pw.println("<TD width='15%' align='center'> " + smalltestcases*3 + " </Font></TD>");
			pw.println("<TD width='10%'><Center> " + smallclarity + " </Center></TD><TD width='10%'><Center> " + smallcomplexity + " </Center></TD>");
			pw.println("<TD width='10%'><Center> " + smallfamiliarity + " </Center></TD><TD width='10%'><Center> " + smallverification + " </Center></TD>");
			double smalltcp = clarityfamiliaritylevel(smallclarity)*complixityverificationlevel(smallcomplexity)*clarityfamiliaritylevel(smallfamiliarity)*complixityverificationlevel(smallverification)*(smalltestcases*3)*projLevelAdjFactor;
	//		pw.println("<TD width='15%' align='center'><font color='Brown'><B> " + Math.round(smalltcp) + " </B></Font></TD></TR>");
			pw.println("</TR>");

//			System.out.println("No. of Small Test Cases : " + smalltestcases);
//			System.out.println("Clarity of Small User Stories : " + smallclarity);
//			System.out.println("Complexity of Small User Stories : " + smallcomplexity);
//			System.out.println("Familiarity of Small User Stories : " + smallfamiliarity);
//			System.out.println("Verification of Small User Stories : " + smallverification);

			
			pw.println("<TR><TD width='15%'><Center>Medium</Center></TD><TD width='15%'><Center> " + mediumtestcases + " </Center></TD>");
	//		pw.println("<TD width='15%' align='center'> " + mediumtestcases*3 + " </Font></TD>");
			pw.println("<TD width='10%'><Center> " + mediumclarity + " </Center></TD><TD width='10%'><Center> " + mediumcomplexity + " </Center></TD>");
			pw.println("<TD width='10%'><Center> " + mediumfamiliarity + " </Center></TD><TD width='10%'><Center> " + mediumverification + " </Center></TD>");
			double mediumtcp = clarityfamiliaritylevel(mediumclarity)*complixityverificationlevel(mediumcomplexity)*clarityfamiliaritylevel(mediumfamiliarity)*complixityverificationlevel(mediumverification)*(mediumtestcases*3)*projLevelAdjFactor;
	//		pw.println("<TD width='15%' align='center'><font color='Brown'><B> " + Math.round(mediumtcp) + " </B></Font></TD></TR>");
			pw.println("</TR>");

//			System.out.println("No. of Medium Test Cases : " + mediumtestcases);
//			System.out.println("Clarity of Medium User Stories : " + mediumclarity);
//			System.out.println("Complexity of Medium  User Stories : " + mediumcomplexity);
//			System.out.println("Familiarity of Medium  User Stories : " + mediumfamiliarity);
//			System.out.println("Verification of Medium  User Stories : " + mediumverification);
			
			pw.println("<TR><TD width='15%'><Center>Large</Center></TD><TD width='15%'><Center> " + largetestcases + " </Center></TD>");
	//		pw.println("<TD width='15%' align='center'> " + largetestcases*3 + " </Font></TD>");
			pw.println("<TD width='10%'><Center> " + largeclarity + " </Center></TD><TD width='10%'><Center> " + largecomplexity + " </Center></TD>");
			pw.println("<TD width='10%'><Center> " + largefamiliarity + " </Center></TD><TD width='10%'><Center> " + largeverification + " </Center></TD>");
			double largetcp = clarityfamiliaritylevel(largeclarity)*complixityverificationlevel(largecomplexity)*clarityfamiliaritylevel(largefamiliarity)*complixityverificationlevel(largeverification)*(largetestcases*3)*projLevelAdjFactor;
	//		pw.println("<TD width='15%' align='center'><font color='Brown'><B> " + Math.round(largetcp) + " </B></Font></TD></TR><TR>");
			pw.println("</TR>");

//			System.out.println("No. of Large Test Cases : " + largetestcases);
//			System.out.println("Clarity of Large User Stories : " + largeclarity);
//			System.out.println("Complexity of Large User Stories : " + largecomplexity);
//			System.out.println("Familiarity of Large User Stories : " + largefamiliarity);
//			System.out.println("Verification of Large User Stories : " + largeverification);
			
			pw.println("<TD width='15%'><Center>Extra Large</Center></TD><TD width='15%'><Center> " + extralargetestcases + " </Center></TD>");
	//		pw.println("<TD width='15%' align='center'> " + extralargetestcases*3 + " </Font></TD>");
			pw.println("<TD width='10%'><Center> " + extralargeclarity + " </Center></TD><TD width='10%'><Center> " + extralargecomplexity + " </Center></TD>");
			pw.println("<TD width='10%'><Center> " + extralargefamiliarity + " </Center></TD><TD width='10%'><Center> " + extralargeverification + " </Center></TD>");
			double extralargetcp = clarityfamiliaritylevel(extralargeclarity)*complixityverificationlevel(extralargecomplexity)*clarityfamiliaritylevel(extralargefamiliarity)*complixityverificationlevel(extralargeverification)*(extralargetestcases*3)*projLevelAdjFactor;
	//		pw.println("<TD width='15%' align='center'><font color='Brown'><B> " + Math.round(extralargetcp) + " </B></Font></TD></TR></TABLE>");
			pw.println("</TR></TABLE>");

//			System.out.println("No. of Extra Large Test Cases : " + extralargetestcases);
//			System.out.println("Clarity of Extra Large User Stories : " + extralargeclarity);
//			System.out.println("Complexity of Extra Large User Stories : " + extralargecomplexity);
//			System.out.println("Familiarity of Extra Large User Stories : " + extralargefamiliarity);
//			System.out.println("Verification of Extra Large User Stories : " + extralargeverification);

			
			pw.println("<BR><hr size='1' color='#008000'><b><p><font face='Arial' color='#008000'><b>Testing Effort:</b></font></p>");
			pw.println("<TABLE border='2' cellspacing='value' cellpadding='2' rules='all'>");
			
			pw.println("<TR><TD width='300' align='center'><font color='Brown'><B>User Story Type</B></Font></TD>");
			pw.println("<TD width='300' align='center'><font color='Brown'><B>No. of User Stories</B></Font></TD>");
	//		pw.println("<TD width='300' align='center'><font color='Brown'><B>Test Design & Execution (TSP)</B></Font></TD>");
			pw.println("<TD width='300' align='center'><font color='Brown'><B>QA Effort (in hours) ===>>></B>");
			pw.println("<TD width='300' align='center'><font color='Brown'><B>Test Planning & Backlog Refinement Effort</B></TD>");
			pw.println("<TD width='300' align='center'><font color='Brown'><B>Test Design Effort</B></TD>");
			pw.println("<TD width='300' align='center'><font color='Brown'><B>Test Execution Effort</B></TD>");
			pw.println("<TD width='300' align='center'><font color='Brown'><B>Regression Testing Effort</B></TD></Font></TR>");
			
			
			pw.println("<TR><TD width='300'><Center>Extra Small</Center></TD>");
			pw.println("<TD width='300'><Center> " + extrasmallnumber + "</Center></TD>");
			
//			System.out.println("No. of Extra Small User Stories : " + extrasmallnumber);
			
	//		pw.println("<TD width='300' align='center'>" + Math.round(extrasmallnumber*extrasmalltcp) + " </TD>");
			double extrasmallstoryeffort=0;
			extrasmallstoryeffort = extrasmallnumber*extrasmalltcp*DomainLevelComplexityadjfactor+((extrasmallnumber*extrasmalltcp*DomainLevelComplexityadjfactor*TechnologyUsedadjfactor)/100);
			pw.println("<TD width='300' align='center'> " + Math.round(extrasmallstoryeffort) + " </TD>");
			pw.println("<TD width='300' align='center'> " + Math.round(((extrasmallstoryeffort)*8.42)/100) + " </TD>");
			pw.println("<TD width='300' align='center'> " + Math.round(((extrasmallstoryeffort)*21.71)/100) + " </TD>");
			pw.println("<TD width='300' align='center'> " + Math.round(((extrasmallstoryeffort)*39.34)/100) + " </TD>");
			pw.println("<TD width='300' align='center'> " + Math.round(((extrasmallstoryeffort)*9.47)/100) + " </TD></TR>");		
			
			pw.println("<TR><TD width='300'><Center>Small</TD><TD width='300'><Center> " + smallnumber + "</Center></TD>");
			
//			System.out.println("No. of Small User Stories : " + smallnumber);
			
//			pw.println("<TD width='300' align='center'> " + Math.round(smallnumber*smalltcp) + " </TD>");
			double smallstoryeffort=0;		
			smallstoryeffort = smallnumber*smalltcp*DomainLevelComplexityadjfactor+((smallnumber*smalltcp*DomainLevelComplexityadjfactor*TechnologyUsedadjfactor)/100);
			pw.println("<TD width='300' align='center'> " + Math.round(smallstoryeffort) + " </TD>");
			pw.println("<TD width='300' align='center'> " + Math.round(((smallstoryeffort)*8.42)/100) + " </TD>");
			pw.println("<TD width='300' align='center'> " + Math.round(((smallstoryeffort)*21.71)/100) + " </TD>");
			pw.println("<TD width='300' align='center'> " + Math.round(((smallstoryeffort)*39.34)/100) + " </TD>");
			pw.println("<TD width='300' align='center'> " + Math.round(((smallstoryeffort)*9.47)/100) + " </TD></TR>");		
	
			
			pw.println("<TR><TD width='300'><Center>Medium</Center></TD><TD width='300'><Center> " + mediumnumber + "</Center></TD>");
			
//			System.out.println("No. of Medium User Stories : " + mediumnumber);
			
	//		pw.println("<TD width='300' align='center'> " + Math.round(mediumnumber*mediumtcp) + " </TD>");
			double mediumstoryeffort=0;	
			mediumstoryeffort = mediumnumber*mediumtcp*DomainLevelComplexityadjfactor+((mediumnumber*mediumtcp*DomainLevelComplexityadjfactor*TechnologyUsedadjfactor)/100);
			pw.println("<TD width='300' align='center'> " + Math.round(mediumstoryeffort) + " </TD>");
			pw.println("<TD width='300' align='center'> " + Math.round(((mediumstoryeffort)*8.42)/100) + " </TD>");
			pw.println("<TD width='300' align='center'> " + Math.round(((mediumstoryeffort)*21.71)/100) + " </TD>");
			pw.println("<TD width='300' align='center'> " + Math.round(((mediumstoryeffort)*39.34)/100) + " </TD>");
			pw.println("<TD width='300' align='center'> " + Math.round(((mediumstoryeffort)*9.47)/100) + " </TD></TR>");		
	
			
			pw.println("<TR><TD width='300'><Center>Large</Center></TD><TD width='300'><Center> " + largenumber + "</Center></TD>");
			
//			System.out.println("No. of Large User Stories : " + largenumber);
			
	//		pw.println("<TD width='300' align='center'> " + Math.round(largenumber*largetcp) + " </TD>");
			double largestoryeffort=0;
			largestoryeffort = largenumber*largetcp*DomainLevelComplexityadjfactor+((largenumber*largetcp*DomainLevelComplexityadjfactor*TechnologyUsedadjfactor)/100);
			pw.println("<TD width='300' align='center'> " + Math.floor(largestoryeffort) + " </TD>");
			pw.println("<TD width='300' align='center'> " + Math.floor(((largestoryeffort)*8.42)/100) + " </TD>");
			pw.println("<TD width='300' align='center'> " + Math.floor(((largestoryeffort)*21.71)/100) + " </TD>");
			pw.println("<TD width='300' align='center'> " + Math.floor(((largestoryeffort)*39.34)/100) + " </TD>");
			pw.println("<TD width='300' align='center'> " + Math.floor(((largestoryeffort)*9.47)/100) + " </TD></TR>");		
	
			
			pw.println("<TR><TD width='300'><Center>Extra Large</Center></TD><TD width='300'><Center> " + extralargenumber + "</Center></TD>");
			
//			System.out.println("No. of Extra Large User Stories : " + extralargenumber);
			
	//		pw.println("<TD width='300' align='center'> " + Math.round(extralargenumber*extralargetcp) + " </TD>");
			double extralargestoryeffort=0;
			extralargestoryeffort = extralargenumber*extralargetcp*DomainLevelComplexityadjfactor+((extralargenumber*extralargetcp*DomainLevelComplexityadjfactor*TechnologyUsedadjfactor)/100);
			pw.println("<TD width='300' align='center'> " + Math.floor(extralargestoryeffort) + " </TD>");
			pw.println("<TD width='300' align='center'> " + Math.floor(((extralargestoryeffort)*8.42)/100) + " </TD>");
			pw.println("<TD width='300' align='center'> " + Math.floor(((extralargestoryeffort)*21.71)/100) + " </TD>");
			pw.println("<TD width='300' align='center'> " + Math.floor(((extralargestoryeffort)*39.34)/100) + " </TD>");
			pw.println("<TD width='300' align='center'> " + Math.floor(((extralargestoryeffort)*9.47)/100) + " </TD></TR></TABLE>");		
	
		
			double totaleffort = Math.floor(extrasmallstoryeffort) + Math.floor(smallstoryeffort) + Math.floor(mediumstoryeffort) + Math.floor(largestoryeffort) + Math.floor(extralargestoryeffort);

			String AgileTestEstimationParameters = null; 
			AgileTestEstimationParameters = UserName  + " , " +  Password  + " , " +  TechnologyUsed  + " , " +  DomainLevelComplexity  + " , " +  Location  + " , " +  ProgressionAutomationInfrastructureAvailablity  + " , " +  RegressionAutomationInfrastructureAvailablity  + " , " +  Automation  + " , " +  DeploymentInfrastructureAutomated  + " , " +  TestManagement  + " , " +  TestData  + " , " +  TestEnvironment  + " , " +  refacNetworkConnectivitytoring  + " , " +  ProactiveMonitoring  + " , " +  SupportfromClientmanagement  + " , " +  SupportfromVendormanagement  + " , " +  ProductOrBusinessOwnersAvailability  + " , " +  AgileAwarenessProductOrBusinessOwners  + " , " +  SupportTeamsAvailability  + " , " +  OnsiteOrNearshoreCoordinatorsRoleResponsibilities  + " , " +  ReadWriteAccess  + " , " +  DomainKnowledge  + " , " +  ReusabilityManualTests  + " , " +  AgileAwarenessTesters  + " , " +  Collaboration  + " , " +  TurnAroundTime  + " , " +  Refactoring  + " , " +  Cycles  + " , " +  projLevelAdjFactor  + " , " +  extrasmalltestcases  + " , " +  extrasmallclarity  + " , " +  extrasmallcomplexity  + " , " +  extrasmallfamiliarity  + " , " +  extrasmallverification  + " , " +  smalltestcases  + " , " +  smallclarity  + " , " +  smallcomplexity  + " , " +  smallfamiliarity  + " , " +  smallverification  + " , " +  mediumtestcases  + " , " +  mediumclarity  + " , " +  mediumcomplexity  + " , " +  mediumfamiliarity  + " , " +  mediumverification  + " , " +  largetestcases  + " , " +  largeclarity  + " , " +  largecomplexity  + " , " +  largefamiliarity  + " , " +  largeverification  + " , " +  extralargetestcases  + " , " +  extralargeclarity  + " , " +  extralargecomplexity  + " , " +  extralargefamiliarity  + " , " +  extralargeverification  + " , " +  extrasmallnumber  + " , " +  extrasmallstoryeffort  + " , " +  smallnumber  + " , " +  smallstoryeffort  + " , " +  mediumnumber  + " , " +  mediumstoryeffort  + " , " +  largenumber  + " , " +  largestoryeffort  + " , " +  extralargenumber  + " , " +  extralargestoryeffort  + " , " +  totaleffort ;

	        updateFile(AgileTestEstimationParameters);


//			System.out.println("Long String : " + AgileTestEstimationParameters);
			
			pw.println("<center><BR><H1>Total QA Effort = ~ " + Math.round(totaleffort) + " hours (~" + Math.floor(totaleffort/24) + ") days </H1>");
			pw.println("<a href='http://in-pnq-coe07:8090/Tesla/'> Back </a></center></body></html>");
	        }
	        else
	        {    	
//	        System.out.println("User Name : " + UserName);
//	        System.out.println("Password : " + Password);
	        pw.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Transitional//EN'><HTML><HEAD><TITLE> Test Effort Calculation </TITLE>");
			pw.println("<META NAME='Generator' CONTENT='EditPlus'><META NAME='Author' CONTENT=''><META NAME='Keywords' CONTENT=''>");
			pw.println("<META NAME='Description' CONTENT=''> </HEAD> <BODY bgcolor='#E6E6FA'><center><font face='Times New Roman' size='5' color='#000080'>");
			pw.println("<b> Agile Test Estimation (Error Page) </b></font></center>");
			pw.println("<center><font face='Times New Roman' size='1' color='#000080'><b> <I>[Researched & Developed (R&D) By Mothukuru Sreenivas, AgileCoE/UTO] </I></b></font></center><hr size='1' color='#008000'>");
			pw.println("<BR><BR><BR><BR><BR><BR><center><font face='Times New Roman' size='5' color='RED'><center>Invalid User Name <font face='Times New Roman' size='5' color='BLACK'>'  " + UserName + "  '</FONT> and/or Password <font face='Times New Roman' size='5' color='BLACK'>'  " + Password + "  '</FONT> ! Please provide valid credentials.");
			pw.println("<BR><center> or </FONT><BR> <font face='Times New Roman' size='5' color='BLUE'> Kindly reach out to 'sreenivas.mothukuru@capgemini.com' for Agile Test Estimation needs </FONT>");
			pw.println("<BR><BR><a href='http://in-pnq-coe07:8090/Tesla/'> Back </a></center></body></html>");
	        }        		
	        
	    }catch(Exception e)
	     {
	        System.out.println("Error" );
	        e.printStackTrace();
	    }
    }        
}