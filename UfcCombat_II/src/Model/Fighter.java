package Model;

import java.util.ArrayList;

public class Fighter {
	private int Id;
	private String Name;
	private String Category;
	private String Parents;
	private String Sex;
	private int Life;
	private int Point;
	private ArrayList<Actions> ActionsList = new ArrayList<Actions>();
	private ArrayList<Skills> SkillsList = new ArrayList<Skills>();
	private EntityControllerBase Controller;

	// Constructor
	public Fighter(String name, String parents, String category, String sex, Player player, int point) {
		Name = name;
		Category = category;
		Parents = parents;
		Sex = sex;
		Controller = player;
		Life = 100;
		Point = point;
	}

	public Fighter(String name, String parents, String category, String sex, Npc npc, int point) {
		Name = name;
		Category = category;
		Parents = parents;
		Sex = sex;
		Controller = npc;
		Life = 100;
		Point = point;
	}

	public Fighter() {}
	
	// GetSet

	public int GetId() {
		return Id;
	}

	public String GetName() {
		return Name;
	}

	public int GetLife() {
		return Life;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getParents() {
		return Parents;
	}

	public void setParents(String parents) {
		Parents = parents;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public void SetLifeDamage(int damage) {
		Life -= damage;
	}

	public void SetLifeCure(int cure) {
		Life = cure;
	}

	public int GetPoint() {
		return Point;
	}

	public void SetPoint(int point) {
		Point += point;
	}

	public ArrayList<Actions> GetActionsList() {
		return ActionsList;
	}

	public void SetActionsList(ArrayList<Actions> actionsList) {
		ActionsList = actionsList;
	}

	// retorna lista de poderes
	public ArrayList<Skills> GetSkillsList() {
		return SkillsList;
	}

	// retorna entity poder invocado
	public Skills GetSkills(int val) {
		int number = val;
		return SkillsList.get(number);
	}

	public void SetSkillsList() {
		SkillsList.add(new Boxe());
		SkillsList.add(new JiuJitsu());
		SkillsList.add(new MuayThai());
		SkillsList.add(new Karate());
		SkillsList.add(new Wrestling());
	}
	
	public void RemoveSkillsList(Skills skills) {
		SkillsList.remove(skills);
	}

	public EntityControllerBase GetController() {
		return Controller;
	}

	// ataques simples
	public int GetPunch() {
		return 5;
	}

	public int GetKick() {
		return 10;
	}
}