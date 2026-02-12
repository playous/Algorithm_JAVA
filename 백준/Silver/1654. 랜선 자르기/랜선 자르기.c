#include <stdio.h>

int main() {
    int K, N;
    scanf("%d %d", &K, &N);
    int* line = calloc(K, sizeof(int));
    int cnt, last = 0;
    for (int i = 0; i < K; i++) {
        scanf("%d", &line[i]);
        if (line[i] > last)last = line[i];
    }
    long long first = 1, mid, max = 0;

    while (first <= last) {
        mid = (first + last) / 2, cnt = 0;

        for (int i = 0; i < K; i++)
            cnt += line[i] / mid;

        if (cnt >= N) {
            if (max < mid)
                max = mid;
            first = mid + 1;
        }
        else last = mid - 1;
    }
    printf("%lld\n", max);
}
