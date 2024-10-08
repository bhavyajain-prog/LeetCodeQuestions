#include <iostream>
using namespace std;

class ListNode {
    public:
    int val;
    ListNode* next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* head=new ListNode(),*curr=head;
        int carry=0;
        while(l1!=NULL || l2!=NULL) {
            int sum = l1!=NULL?l1->val:0 + l2!=NULL?l2->val:0 + carry;

            curr->next = new ListNode(sum%10);
            carry = sum/10;
            curr = curr->next;
            if(l1!=NULL) l1 = l1->next;
            if(l2!=NULL) l2 = l2->next;
        }
        if(carry>0)
            curr->next = new ListNode(carry);
        return head->next;
    }
};