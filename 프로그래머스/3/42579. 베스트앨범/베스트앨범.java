import java.util.*;

class Solution {

    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Integer>> indexesForGenres = initialize(genres);
        Map<String, Integer> playsForGenres = new HashMap<>();
        //장르별로 그 인덱스로 재생횟수를 통해 정렬을 해야함.
        //많이 재생된 장르를 먼저 판단해야함.
        for (Map.Entry<String, List<Integer>> entry : indexesForGenres.entrySet()) {
            String genre  = entry.getKey();
            List<Integer> indexes = entry.getValue();
            
            int sum = 0;
            for(Integer index : indexes) {
                sum += plays[index];
            }
            playsForGenres.put(genre, sum);
        }
        
        List<String> sortedGenres = new ArrayList<>(playsForGenres.keySet());
        Collections.sort(sortedGenres, (g1,g2) -> playsForGenres.get(g2) - playsForGenres.get(g1));

        List<Integer> bestAlbum = new ArrayList<>();
        
        for (String genre : sortedGenres) {
            List<Integer> songIndexes = indexesForGenres.get(genre);

            Collections.sort(songIndexes, (i1, i2) -> {
                if (plays[i1] != plays[i2]) {
                    return plays[i2] - plays[i1]; 
                } else {
                    return i1 - i2; 
                }
            });
            
            bestAlbum.add(songIndexes.get(0));
            if (songIndexes.size() > 1) {
                bestAlbum.add(songIndexes.get(1));
            }
        }

        return bestAlbum.stream().mapToInt(i -> i).toArray();
    
    }
    
    // 장르별로 플레이 횟수 인덱스를 가져왔음.
    private Map<String, List<Integer>> initialize(final String[] genres) {
        Map<String, List<Integer>> playsForGenres = new HashMap<>();
        
        for (int i = 0; i < genres.length; i ++) {
            String genre = genres[i];
            
            playsForGenres.computeIfAbsent(genre, k -> new ArrayList<>()).add(i);
        }
        
        return playsForGenres;
    } 
}