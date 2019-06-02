package Controller;

import Model.FileViewModel;
import java.util.ArrayList;
import File.Archive;

public class StartController {

	Archive archive;

	public StartController() {
		this.archive = new Archive();
	}

	public void Go() {
		InvokeFile();
		BindFileEntity();
	}

	public void InvokeFile() {
		try {
			archive.ReadArchivesPath();
			archive.ReadArchives(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void BindFileEntity() {
		ArrayList<FileViewModel> fileViewModel = new ArrayList<FileViewModel>();
		fileViewModel = archive.GetListFileViewModel();
	}
}
