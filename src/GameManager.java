import java.awt.CardLayout;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.JPanel;

/**
 *
 * @author samet
 */
public class GameManager {

	private MyComponents myComponents;
	private Model model;
	private CardLayout cardLayout;
	private JPanel card;
	private int levelNo;
	// private FileSystem fileSystem = new FileSystem();
	GameView gv;

	// // FileSytsme improvement
	// private int castle[] = new int[4];
	// private int forestAndLake[] = new int[9];
	// private int mapWidth;
	// private int mapLength;
	// private int size_of_soldiers;
	// private ArrayList<Integer> shape = new ArrayList<Integer>();

	public GameManager(GameView gv, int levelNo, CardLayout cardLayout, JPanel card) throws IOException {
		this.cardLayout = cardLayout;
		this.card = card;
		this.levelNo = levelNo;
		this.gv = gv;
		run();
	}

	public void run() throws IOException {

		// fileSystem.createLevel(levelNo);
		// castle = fileSystem.getCastle();
		// Castle castle = new Castle(this.castle[0], this.castle[1], this.castle[2],
		// this.castle[3], Color.green);
		// mapWidth = fileSystem.getMapWidth();
		// mapLength = fileSystem.getMapLength();
		//
		// model = new Model(mapWidth, mapLength, castle, levelNo);
		//
		// size_of_soldiers = fileSystem.getNumberOfSoldiers();
		//
		// for(int i = 0; i < size_of_soldiers; i++)
		// {
		// model.addSoldier(fileSystem.getDataStructure().getInst()[0],
		// fileSystem.getDataStructure().getInst()[1],
		// fileSystem.getDataStructure().getNum()[0],
		// fileSystem.getDataStructure().getNum()[1],
		// fileSystem.getDataStructure().getRoute());
		// fileSystem.incrementSize();
		// }
		// fileSystem.resetSize();
		//
		// forestAndLake = fileSystem.getForestAndLake();
		//
		// for (int i = forestAndLake[0]; i < forestAndLake[1]; i++) {
		// model.addLake(i, forestAndLake[2]);
		// model.addLake(i, forestAndLake[3]);
		// model.addEnemyArmada(i, forestAndLake[4], false, null);
		// //model.addAllyArmada(i, forestAndLake[6], fileSystem.getArmada());
		// }
		//
		// for (int i = forestAndLake[7]; i < forestAndLake[8]; i++) {
		// model.addForest(i, forestAndLake[8]);
		// }
		//
		//
		// for(int i = 0; i < 6; i++)
		// {
		// shape = fileSystem.getDataStructure().getShape();
		// int listToArray [] = new int [shape.size()];
		// for(int r = 0; r < shape.size(); r++)
		// listToArray[r] = shape.get(r);
		// model.addWallOrChain(fileSystem.getDataStructure().getChainOrWall(),listToArray);
		// fileSystem.incrementSize();
		// }
		// fileSystem.resetSize();
		//
		// myComponents = new MyComponents(gv, model, cardLayout, card, levelNo);

		Castle castle = new Castle(3, 3, 2, 3, Color.green);
		if (levelNo == 1) {
			// Castle castle = new Castle(1, 2, 1, 3, Color.green);
			int mapWidth = 8;
			int mapLength = 8;
			model = new Model(mapWidth, mapLength, castle, levelNo);

			// Allies
			model.addSoldier(true, false, 0, 3);
			model.addSoldier(true, false, 2, 4);
			model.addSoldier(true, false, 4, 5);

			// Enemies
			model.addSoldier(false, false, 1, 1);
			model.addSoldier(false, true, 3, 2);
			model.addSoldier(false, true, 3, 5);

			model.addLake(4, 0);
			model.addLake(5, 0);
			model.addLake(6, 0);
			model.addLake(4, 1);
			model.addLake(6, 1);
			model.addLake(7, 1);
			model.addLake(5, 2);
			model.addLake(6, 2);
			model.addLake(7, 2);
			model.addLake(4, 3);
			model.addLake(5, 3);
			model.addLake(7, 3);

			model.addAllyArmada(4, 2, false);

			model.addEnemyArmada(5, 1, false);
			model.addEnemyArmada(6, 3, true);

			model.addForest(1, 2);
			model.addForest(1, 3);
			model.addForest(2, 2);
			model.addForest(1, 3);
			model.addForest(2, 2);
			model.addForest(2, 3);
			model.addForest(6, 5);
			model.addForest(5, 6);
			model.addForest(6, 6);
			model.addForest(7, 4);
			model.addForest(7, 5);
			model.addForest(7, 6);

			for (int i = 1; i < model.mapWidth - 1; i++) {
				model.addForest(i, 7);
			}

			myComponents = new MyComponents(gv, model, cardLayout, card, levelNo);

			model.addWallOrChain(true, Model.RIGHT, Model.DOWN, Model.RIGHT, Model.DOWN);
			model.addWallOrChain(true, Model.DOWN, Model.RIGHT, Model.UP, Model.RIGHT, Model.UP);
			model.addWallOrChain(true, Model.DOWN, Model.RIGHT, Model.UP, Model.RIGHT, Model.UP);
			model.addWallOrChain(true, Model.DOWN, Model.RIGHT, Model.UP, Model.RIGHT, Model.UP);
			model.addWallOrChain(true, Model.UP, Model.RIGHT);
			model.addWallOrChain(true, Model.LEFT, Model.UP, Model.RIGHT, Model.UP);
			model.addWallOrChain(false, Model.LEFT);
			model.addWallOrChain(false, Model.RIGHT, Model.DOWN, Model.RIGHT, Model.DOWN);
		}
		//
		if (levelNo == 2) {

			castle = new Castle(1, 1, 2, 1, Color.green);

			int mapWidth = 5;
			int mapLength = 4;
			model = new Model(mapWidth, mapLength, castle, levelNo);

			// Allies
			model.addSoldier(true, false, 2, 0);
			model.addSoldier(true, false, 2, 3);
			model.addSoldier(true, false, 3, 2);

			// Enemies
			model.addSoldier(false, false, 1, 2);
			model.addSoldier(false, false, 1, 3);
			model.addSoldier(false, false, 3, 0);
			model.addSoldier(false, false, 4, 2);
			// 5, 4

			model.addWallOrChain(true, Model.UP, Model.RIGHT, Model.DOWN, Model.RIGHT, Model.DOWN);
			model.addWallOrChain(true, Model.UP, Model.RIGHT, Model.DOWN);
			model.addWallOrChain(true, Model.DOWN, Model.RIGHT, Model.DOWN, Model.RIGHT);
			model.addWallOrChain(true, Model.LEFT, Model.UP, Model.RIGHT, Model.UP, Model.LEFT, Model.UP);
			model.addWallOrChain(false, Model.DOWN, Model.RIGHT, Model.DOWN, Model.RIGHT);
			model.addWallOrChain(false, Model.LEFT, Model.UP, Model.RIGHT, Model.UP, Model.LEFT, Model.UP);

			myComponents = new MyComponents(gv, model, cardLayout, card, levelNo);

		}
<<<<<<< HEAD
=======
		fileSystem.resetSize();
		
		myComponents = new MyComponents(gv, model, cardLayout, card, levelNo);
>>>>>>> 24f16d704b382f6e4da443c5f8e7856161561160

	}

	public MyComponents getPanel() {
		return myComponents;
	}

	public int getInitialXShift() {
		return model.getInitialXShift();
	}

	public int getMapWidth() {
		return model.getMapWidth();
	}

	public int getSquareWidth() {
		return model.getSquareWidth();
	}

	public int getInitialYShift() {
		return model.getInitialYShift();
	}

	public int getSquareHeight() {
		return model.getSquareHeight();
	}

	public int getMapLength() {
		return model.getMapLength();
	}

	void reset() {
		model.reset();
	}

	public void startTimers() {
		model.startTimers();
		myComponents.startTimer();
	}

	public void stopTimers() {
		myComponents.stopTimer();
		model.stopTimers();
	}
}