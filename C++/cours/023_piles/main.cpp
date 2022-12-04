#include <iostream>
#include <string>
#include <stack>

/*
    size(), empty()
    push(), pop(), top()
*/

int main()
{
    std::stack<int> st;
    st.push(1);
    st.push(2);
    st.push(3);
    st.push(4);

    while(!st.empty())
    {
        std::cout << st.top() << " ";
        st.pop();
    }
    std::cout << "\n";

    return 0;
}