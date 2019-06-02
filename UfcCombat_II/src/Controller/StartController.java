package Controller;

import Model.Actions;
import Model.Championship;
import Model.Fighter;
import Model.FileViewModel;
import Model.Npc;

import java.io.IOException;
import java.util.ArrayList;
import File.Archive;

public class StartController {

	private Archive archive;
	private int archiveNumber = 0;
	private Championship champioonship;

	public StartController() {
		this.archive = new Archive();
	}

	public void Go() {
		InvokeFile();
		for (int i = 0; i < archive.getCountArray(); i++) {
			archiveNumber = i;
			BindFile();
			BindFileEntity();
			champioonship.SetCombat();
			champioonship.InvokeCombat();
		}
	}

	public void InvokeFile() {
		try {
			archive.ReadArchivesPath();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void BindFile() {
		try {
			archive.ReadArchives(archiveNumber);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void BindFileEntity() {
		champioonship = new Championship(archive.getArrayFile(archiveNumber));
		ArrayList<Fighter> listFighter = new ArrayList<Fighter>();
		ArrayList<FileViewModel> listFileViewModel = new ArrayList<FileViewModel>();
		listFileViewModel = archive.GetListFileViewModel();
		int contadorLuta = 1, contadorLinha = 0;
		Npc npc = new Npc(1, "Default");

		for (int i = 0; i < listFileViewModel.size(); i++) {
			if (contadorLuta == listFileViewModel.get(i).getContadorLuta()) {

				ArrayList<Actions> ActionsListUm = new ArrayList<Actions>();
				ArrayList<Actions> ActionsListDois = new ArrayList<Actions>();
				Actions actionsUm;
				Actions actionsDois;
				Fighter fighterUm;
				Fighter fighterDois;

				for (FileViewModel fileViewModel : listFileViewModel) {
					if (contadorLuta == fileViewModel.getContadorLuta()) {
						actionsUm = new Actions(fileViewModel.getDefesaUm(), fileViewModel.getAtaqueUm(),
								fileViewModel.getSocoUm(), fileViewModel.getChuteUm(), fileViewModel.getPoderUm(),
								fileViewModel.getModalidadeUm());
						actionsDois = new Actions(fileViewModel.getDefesaDois(), fileViewModel.getAtaqueDois(),
								fileViewModel.getSocoDois(), fileViewModel.getChuteDois(), fileViewModel.getPoderDois(),
								fileViewModel.getModalidadeDois());
						ActionsListUm.add(actionsUm);
						ActionsListDois.add(actionsDois);
						contadorLuta = fileViewModel.getContadorLuta();
						contadorLinha++;
					}
				}
				int idInfo = contadorLinha - 1;
				fighterUm = new Fighter(listFileViewModel.get(idInfo).getNomeUm(),
						listFileViewModel.get(idInfo).getPaisUm(), listFileViewModel.get(idInfo).getCategoriaUm(),
						listFileViewModel.get(idInfo).getSexoUm(), npc, 0);
				fighterUm.SetActionsList(ActionsListUm);
				fighterUm.SetSkillsList();
				fighterDois = new Fighter(listFileViewModel.get(idInfo).getNomeDois(),
						listFileViewModel.get(idInfo).getPaisDois(), listFileViewModel.get(idInfo).getCategoriaDois(),
						listFileViewModel.get(idInfo).getSexoDois(), npc, 0);
				fighterDois.SetActionsList(ActionsListDois);
				fighterDois.SetSkillsList();

				contadorLuta++;
				listFighter.add(fighterUm);
				listFighter.add(fighterDois);

			}
		}

		champioonship.SetFighterList(listFighter);
	}
}
