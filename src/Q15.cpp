#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
using namespace std;

class Solution {
    public:
        vector<vector<int>> threeSum(vector<int>& nums) {
            vector<vector<int>> result;
            if(nums.size() < 3) return result;
            sort(nums.begin(), nums.end());
            set<vector<int>> set;
            for(int i = 0; i < nums.size()-2;i++) {
                int j = i+1;
                int k = nums.size()-1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0) {
                        set.insert({nums[i],nums[j],nums[k]});
                        j++;
                        k--;
                    } else if(sum < 0) j++;
                    else k--;
                }
            }
            for(auto& num : set) {
                result.push_back(num);
            }
            return result;
        }
};

