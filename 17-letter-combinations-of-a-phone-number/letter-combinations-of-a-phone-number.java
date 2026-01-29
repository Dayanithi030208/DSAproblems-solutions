class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        findletterCombinations(digits,new String(),0,result,map);
        return result;
    }
    private void findletterCombinations(String digits,String temp,int index,List<String> result,HashMap<Character,String> map){
        if(index==digits.length()){
            result.add(temp);
            return ;
        }
        String current=map.get(digits.charAt(index));
        for(int i=0;i<current.length();i++){
            char c = current.charAt(i);
            findletterCombinations(digits,temp+c,index+1,result,map);
        }
    }
}