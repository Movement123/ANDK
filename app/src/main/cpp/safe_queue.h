//
// Created by rengu on 2020/6/11.
//

#ifndef ANDK_SAFE_QUEUE_CPP
#define ANDK_SAFE_QUEUE_CPP

#include <queue>
#include <pthread.h>


using namespace std;

template<typename T>
class SafeQueue {
    typedef void (*ReleaseCallback)(T&);

public:
    SafeQueue() {
        pthread_mutex_init(&mutex, 0);
        pthread_cond_init(&cond, 0);

    }

    ~SafeQueue() {
        pthread_mutex_destroy(&mutex);
        pthread_cond_destroy(&cond);

    }

    void push(T value) {
        pthread_mutex_lock(&mutex);
        q.push(value);
        pthread_cond_signal(&cond);
        pthread_mutex_unlock(&mutex);
    }

    int pop(T &value) {
        int ret = 0;
        pthread_mutex_lock(&mutex);
        while (q.empty()) {

            pthread_cond_wait(&cond, &mutex);
        }
        if(!q.empty()){
            value = q.front();
            q.pop();
            ret = 1;
        }
        pthread_mutex_unlock(&mutex);
        return ret;
    }

    void clear(){

        pthread_mutex_lock(&mutex);

        uint32_t size = q.size();
        for (int i = 0; i < size; ++i) {
            T value = q.front();
            if(releaseCallback){
                releaseCallback(value);
            }
            q.pop();
        }

        pthread_mutex_unlock(&mutex);

    }

    void setReleaseCallback(ReleaseCallback releaseCallback){

        this->releaseCallback = releaseCallback;
    }

private:
    pthread_mutex_t mutex;
    pthread_cond_t cond;
    queue <T> q;
    ReleaseCallback releaseCallback;

};

#endif //ANDK_SAFE_QUEUE_CPP
