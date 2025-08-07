class Solution {
    public int minimumRefill(int[] plant, int capacityA, int capacityB) {
        int n = plant.length;
        int left = 0, right = n-1;
        int remA = capacityA, remB = capacityB;
        int refil = 0;
        while(left<right){

            if(plant[left] <= remA ) remA-=plant[left];
            else{
                refil++;
                remA = capacityA - plant[left];
            }
            if(plant[right] <= remB ) remB-=plant[right];
            else{
                refil++;
                remB = capacityB - plant[right];
            }
            left++;
            right--;

        }

        if(n%2 != 0){
            if(Math.max(remA,remB) < plant[left]) refil++;
        }
        return refil;
    }
}