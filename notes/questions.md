## 1.res.add(new ArrayList<>(list))和res.add(list)的区别
```
List<List<String>> res = new ArrayList<>();
List<String> list = new ArrayList<>();
list.add(1);
list.add(2);
res.add(new ArrayList<>(list));
res.add(list);
```
+ 区别
  - res.add(list) 只是将res尾部指向了list地址，后续list内容的变化会导致res的变化。
  - res.add(new ArrayList<>(list)) 开辟一个独立地址，地址中存放的内容为list，后续list的变化不会影响到res。
  
## 2.回溯算法与DFS深搜
+ 回溯和深度优先搜索的区别
  - 回溯是一种更通用的算法。可以用于任何类型的结构，其中可以消除域的部分 ——无论它是否是逻辑树。
  - 深度优先搜索是与搜索树或图结构相关的特定回溯形式。它使用回溯作为其使用树的方法的一部分，但仅限于树/图结构。
  - 回溯和 DFS 之间的区别在于回溯处理隐式树而 DFS 处理显式树。这似乎微不足道，但它意味着很多。当通过回溯访问问题的搜索空间时，隐式树在其中间被遍历和修剪。然而对于 DFS 来说，它处理的树/图是明确构造的，并且在完成任何搜索之前已经抛出了不可接受的情况，即修剪掉了。
  - 因此，回溯是隐式树的 DFS，而 DFS 是回溯而不修剪。
