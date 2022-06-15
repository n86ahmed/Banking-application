package Controllers;

import Models.ManagerModel;
import Views.ManagerView;

public class ManagerController {

	private ManagerModel AM;
	private ManagerView AV;
	
	public ManagerController(ManagerModel AM, ManagerView AV) {
		this.AM = AM;
		this.AV = AV;
	}
	public ManagerModel ShowView() {
		AV.PrintAdminScreen(AM);
		return AM;		
	}
	
}
