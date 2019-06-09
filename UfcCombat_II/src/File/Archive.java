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
	private ArrayList<FileViewModel> ListFileViewModel;

	public void ReadArchivesPath() throws IOException {
		this.File = new File(path);
		ArrayFile = this.File.listFiles();
	}

	public void ReadArchives(int val) throws IOException {
		try {
			ListFileViewModel = new ArrayList<FileViewModel>();
			BufferedReader br = new BufferedReader(new FileReader(ArrayFile[val]));
			String arrayTmp[];
			while (br.ready()) {
				String linha = br.readLine();
				arrayTmp = linha.split(";");

				FileViewModel fileTmp = new FileViewModel();
				fileTmp.SetId(Integer.parseInt(arrayTmp[1]));
				fileTmp.SetContadorLuta(Integer.parseInt(arrayTmp[2]));
				fileTmp.SetNomeUm(arrayTmp[3]);
				fileTmp.SetCategoriaUm(arrayTmp[4]);
				fileTmp.SetPaisUm(arrayTmp[5]);
				fileTmp.SetSexoUm(arrayTmp[6]);
				fileTmp.SetDefesaUm(Integer.parseInt(arrayTmp[7]));
				fileTmp.SetAtaqueUm(Integer.parseInt(arrayTmp[8]));
				fileTmp.SetSocoUm(Integer.parseInt(arrayTmp[9]));
				fileTmp.SetChuteUm(Integer.parseInt(arrayTmp[10]));
				fileTmp.SetPoderUm(Integer.parseInt(arrayTmp[11]));
				fileTmp.SetModalidadeUm(Integer.parseInt(arrayTmp[12]));
				fileTmp.SetNomeDois(arrayTmp[13]);
				fileTmp.SetCategoriaDois(arrayTmp[14]);
				fileTmp.SetPaisDois(arrayTmp[15]);
				fileTmp.SetSexoDois(arrayTmp[16]);
				fileTmp.SetDefesaDois(Integer.parseInt(arrayTmp[17]));
				fileTmp.SetAtaqueDois(Integer.parseInt(arrayTmp[18]));
				fileTmp.SetSocoDois(Integer.parseInt(arrayTmp[19]));
				fileTmp.SetChuteDois(Integer.parseInt(arrayTmp[20]));
				fileTmp.SetPoderDois(Integer.parseInt(arrayTmp[21]));
				fileTmp.SetModalidadeDois(Integer.parseInt(arrayTmp[22]));

				this.ListFileViewModel.add(fileTmp);
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public ArrayList<FileViewModel> GetListFileViewModel() {
		return this.ListFileViewModel;
	}

	public String GetArrayFile(int number) {
		return ArrayFile[number].getName();
	}

	public int GetCountArray() {
		return ArrayFile.length;
	}
}
