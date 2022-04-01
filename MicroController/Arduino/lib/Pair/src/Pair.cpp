//
// Created by Ryednap(Ujjwal) on 01/04/22.
//

#include "Pair.h"

template<typename T, typename U>
Pair<T, U>::Pair(T first, U second) : first(first), second(second) {}

template<typename T, typename U>
Pair<T, U>::Pair(const Pair &rhs) {
    Pair(rhs.first, rhs.second);
}

template<typename T, typename U>
bool Pair<T, U>::operator<(const Pair &rhs) const {
    if (first == rhs.first) {
        return second < rhs.second;
    } else return first < rhs.second;
}

template<typename T, typename U>
bool Pair<T, U>::operator==(const Pair &rhs) const {
    return first == rhs.first &&
           second == rhs.second;
}

template<typename T, typename U>
bool Pair<T, U>::operator!=(const Pair &rhs) const {
    return rhs != *this;
}

template<typename U, typename V>
Pair<U, V> & make_pair(U first, V second) {
    return Pair<U, V>(first, second);
}
