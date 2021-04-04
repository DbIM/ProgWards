package Game;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class MapLoader {
    HashMap<Integer, MapBlock> blocks = new HashMap<>();
    MapBlock mapBlock;
    int counter = 0;

    public MapLoader(String mapFile) throws FileNotFoundException {
        String fileName = mapFile;
        FileReader fileIn = new FileReader(fileName);
        Scanner scanner = new Scanner(fileIn);
        int posX = 0;
        int posY = 0;

        while (scanner.hasNextLine()) {
            char[] chars = scanner.nextLine().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                posY = i;
                mapBlock = new MapBlock(posX, posY);
                char letter = chars[i];
                mapBlock.setBlockTypeLetter(letter);
                mapBlock.setPositionX(posX);
                mapBlock.setPositionY(posY);
                if (letter == 'B') {
                    mapBlock.setBlock(true);
                    mapBlock.setName("Block");
                }
                else if (letter == 'R') {
                    mapBlock.setBlock(false);
                    mapBlock.setPic("src/Game/img/onlyRoad.png");
                    mapBlock.setName("Road");
                }
                blocks.put(counter, mapBlock);
                counter++;
            }
            posX++;
        }
        System.out.println("test mapBlocks");
    }

    public Character blockLetter(int posX, int posY){
        char blockLetter;
        for (int i = 0; i<blocks.size(); i++){
           mapBlock = blocks.get(i);
           if (mapBlock.getPositionX() == posX && mapBlock.getPositionY() == posY){
               blockLetter = mapBlock.getBlockTypeLetter();
               return blockLetter;
           }
        }
        return null;
    }

}
