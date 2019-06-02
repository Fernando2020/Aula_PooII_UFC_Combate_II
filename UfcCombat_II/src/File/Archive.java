package File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Model.FileViewModel;

public class Archive {

	private String path = "files/";
	private File File;
	private File ArrayFile[];
	private ArrayList<FileViewModel> ListFileViewModel = new ArrayList<FileViewModel>();

	public void ReadArchivesPath() throws IOException {
		this.File = new File(path);
		ArrayFile = this.File.listFiles();
	}

	public void ReadArchives(int val) throws IOException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(ArrayFile[1]));
			String arrayTmp[];
			while (br.ready()) {
				String linha = br.readLine();
				arrayTmp = linha.split(";");

				FileViewModel fileTmp = new FileViewModel();
				fileTmp.setId(Integer.parseInt(arrayTmp[1]));
				fileTmp.setContadorLuta(Integer.parseInt(arrayTmp[2]));
				fileTmp.setNomeUm(arrayTmp[3]);
				fileTmp.setCategoriaUm(arrayTmp[4]);
				fileTmp.setPaisUm(arrayTmp[5]);
				fileTmp.setSexoUm(arrayTmp[6]);
				fileTmp.setDefesaUm(Integer.parseInt(arrayTmp[7]));
				fileTmp.setAtaqueUm(Integer.parseInt(arrayTmp[8]));
				fileTmp.setSocoUm(Integer.parseInt(arrayTmp[9]));
				fileTmp.setChuteUm(Integer.parseInt(arrayTmp[10]));
				fileTmp.setPoderUm(Integer.parseInt(arrayTmp[11]));
				fileTmp.setModalidadeUm(arrayTmp[12]);
				fileTmp.setNomeDois(arrayTmp[13]);
				fileTmp.setCategoriaDois(arrayTmp[14]);
				fileTmp.setPaisDois(arrayTmp[15]);
				fileTmp.setSexoDois(arrayTmp[16]);
				fileTmp.setDefesaDois(Integer.parseInt(arrayTmp[17]));
				fileTmp.setAtaqueDois(Integer.parseInt(arrayTmp[18]));
				fileTmp.setSocoDois(Integer.parseInt(arrayTmp[19]));
				fileTmp.setChuteDois(Integer.parseInt(arrayTmp[20]));
				fileTmp.setPoderDois(Integer.parseInt(arrayTmp[21]));
				fileTmp.setModalidadeDois(arrayTmp[22]);

				this.ListFileViewModel.add(fileTmp);
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public ArrayList<FileViewModel> GetListFileViewModel(){
		return this.ListFileViewModel;
	}
}
