//
// Created by Ryednap(Ujjwal) on 01/04/22.
//

#ifndef ARDUINO_PAIR_H
#define ARDUINO_PAIR_H


template<typename T, typename U>
struct Pair {
    T first;
    U second;

    Pair() = default;
    Pair(T first, U second);
    Pair(const Pair & rhs);

    bool operator < (const Pair & rhs) const;

    bool operator==(const Pair &rhs) const;

    bool operator!=(const Pair &rhs) const;
};


template<typename U, typename V>
__attribute__((unused)) Pair<U, V> & make_pair(U first, V second);

#endif //ARDUINO_PAIR_H
