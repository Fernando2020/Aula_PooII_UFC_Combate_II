package File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Model.FileViewModel;

/**
 * Classe para ler e gravar o arquivo em entidade e mem�ria, onde ser�o
 * contidos, valores e m�todos para o mesmo.
 * 
 * @author Fernando G. Nogueira.
 * @version 1.0.
 */
public class Archive {

	private String path = "files/";
	private File File;
	private File ArrayFile[];
	private ArrayList<FileViewModel> ListFileViewModel;

	/**
	 * M�todo respons�vel por receber o nome dos arquivos e armazenas em mem�ria.
	 * 
	 * @author Fernando G. Nogueira.
	 * @throws IOException tratamento de exce��o de arquivos
	 */
	public void ReadArchivesPath() throws IOException {
		this.File = new File(path);
		ArrayFile = this.File.listFiles();
	}

	/**
	 * M�todo respons�vel por gerar uma lista de entidade do tipo FileViewModel.
	 * 
	 * @author Fernando G. Nogueira.
	 * @param val - n�mero do arquivo
	 * @throws IOException tratamento de exce��o
	 */
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

	/**
	 * M�todo respons�vel por retornar a lista do tipo FileViewModel.
	 * 
	 * @author Fernando G. Nogueira.
	 * @return ArrayList - Retornar a lista do tipo FileViewModel.
	 */
	public ArrayList<FileViewModel> GetListFileViewModel() {
		return this.ListFileViewModel;
	}

	/**
	 * M�todo respons�vel por retornar o nome dos arquivos.
	 * 
	 * @author Fernando G. Nogueira.
	 * @param number - n�mero do indice.
	 * @return String - Nome dos arquivos em mem�ria.
	 */
	public String GetArrayFile(int number) {
		return ArrayFile[number].getName();
	}

	/**
	 * M�todo respons�vel por retornar a quantidade de arquivos em mem�ria.
	 * 
	 * @author Fernando G. Nogueira.
	 * @return Int - Quantidade de arquivos em mem�ria.
	 */
	public int GetCountArray() {
		return ArrayFile.length;
	}
}
