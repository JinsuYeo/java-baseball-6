package baseball;

import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

    String userInput;
    private List<Integer> playerNums;

    public Player(int size) {
        userInput = receiveUserInput();
        checkStringLength(userInput, size);
        checkInt(userInput);
        playerNums = parseNums();
        checkDuplicated(playerNums, size);
    }

    private String receiveUserInput() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    private void checkStringLength(String nums, int length) {
        if (nums.length() != length) {
            throw new IllegalArgumentException("3자릿수를 입력해주세요.");
        }
    }

    private int checkInt(String nums) throws IllegalArgumentException {
        try {
            return Integer.parseInt(nums);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private void checkDuplicated(List<Integer> nums, int size) throws IllegalArgumentException {
        if (nums.stream().distinct().count() != size) {
            throw new IllegalArgumentException("서로 다른 3개의 수를 입력해주세요.");
        }
    }

    private List<Integer> parseNums() throws IllegalArgumentException {
        try {
            List<Integer> playerNums = new ArrayList<>();
            for (int i = 0; i < userInput.length(); i++) {
                playerNums.add(userInput.charAt(i) - '0');
            }
            return playerNums;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

    }

    public List<Integer> getPlayerNums() {
        return Collections.unmodifiableList(playerNums);
    }
}
