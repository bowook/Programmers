class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String skill_tree : skill_trees) {
            String filtered = "";
            for (char c : skill_tree.toCharArray()) {
                if (skill.indexOf(c) != -1) {
                    filtered += c;
                }
            }

            if (skill.startsWith(filtered)) {
                answer++;
            }
        }
        
        return answer;
    }
}
