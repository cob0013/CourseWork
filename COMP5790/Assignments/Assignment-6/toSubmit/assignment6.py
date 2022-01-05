import random
import math
import matplotlib.pyplot as plt
class PLSA:
    def __init__(self, documents, k, l, delta, iterations):
        self.documents = documents
        self.k = k
        self.l = l
        self.background = dict()
        self.count = dict()
        self.delta = delta
        self.iterations = iterations
        random.seed(42)

      

        # set up background language model
        for doc in documents:
            for word in doc:
                if word not in self.background:
                    self.background[word] = 0
                self.background[word] += 1
        for key in self.background.keys():
            self.background[key] /= len(self.background)

        # init counts
        for i in range(len(self.documents)):
            self.count[i] = dict()
            for word in documents[i]:
                if word not in self.count[i]:
                    self.count[i][word] = 0
                self.count[i][word] += 1
        # init theta
        self.theta = dict()
        for i in range(self.k):
            self.theta[i] = dict()
            normalization = 0
            for word in self.background.keys():
                self.theta[i][word] = random.random()
                normalization += self.theta[i][word]
            for word in self.theta[i].keys():
                self.theta[i][word] /= normalization
        # init pi
        self.pi = dict()
        for i in range(len(self.documents)):
            k_likelihood = [random.random() for i in range(self.k)]
            normalized_k_likelihood = [k / sum(k_likelihood) for k in k_likelihood]
            self.pi[i] = normalized_k_likelihood

    def e_step(self):
        self.nwk = {}
        self.ndk = [[0 for i in range(self.k)] for j in range(len(self.documents))]
        for i in range(len(self.documents)):
            for word in self.count[i].keys():
                if word not in self.nwk:
                    self.nwk[word] = [0 for i in range(self.k)]
                c = self.count[i][word]
                denominator_pk = 0
                for k in range(self.k):
                    denominator_pk += self.theta[k][word] * self.pi[i][k]
                for k in range(self.k):
                    num_pk = self.pi[i][k] * self.theta[k][word]
                    num_pb = self.l * self.background[word]
                    denominator_pb = num_pb + (1 - self.l) * denominator_pk
                    if denominator_pk == 0:
                        pk = 0
                    else:
                        pk = num_pk / denominator_pk
                    if denominator_pb == 0:
                        pb = 0
                    else:
                        pb = num_pb / denominator_pb
                    self.nwk[word][k] += (c * pk * (1 - pb))
                    self.ndk[i][k] += (c * pk * (1 - pb))

    def m_step(self):
        # update theta
        for k in range(self.k):
            den = 0
            for word in self.background.keys():
                den += self.nwk[word][k]
            for word in self.background.keys():
                self.theta[k][word] = self.nwk[word][k] / den
        # update pi
        for i in range(len(self.documents)):
            den = 0.0
            for k in range(self.k):
                den += self.ndk[i][k]
            for k in range(self.k):
                if den == 0:
                    self.pi[i][k] = 1 / self.k
                else:
                    self.pi[i][k] = self.ndk[i][k] / den
    

    def loglikelihood(self):
        ll = 0
        for i in range(len(self.documents)):
            for j in range(len(self.documents[i])):
                tmp = 0
                for k in range(self.k):
                    tmp += self.theta[k][self.documents[i][j]] * self.pi[i][k]
                ll += math.log(self.l * self.background[self.documents[i][j]] + (1- self.l) * tmp, 2)
        return ll


    def run(self):
        ll_last_run = 0
        log_like = []
        relative_change_data = []
        for i in range(self.iterations):
            print(i)
            self.e_step()
            self.m_step()
            ll_this_run = self.loglikelihood()
            log_like.append(ll_this_run)
            print("Logliklehood this run: " + str(ll_this_run))
            if (i == 0):
                ll_last_run = ll_this_run
                continue
            relative_change = abs((ll_last_run - ll_this_run) / ll_last_run)
            ll_last_run = ll_this_run
            print("Relative change is: " + str(relative_change))
            relative_change_data.append(relative_change)
            if relative_change < self.delta:
                break
        self.rcData = list(relative_change_data)
        self.logLikeData = list(log_like)

    def graph(self):
        plt.xlabel('runs')
        plt.ylabel('Log liklehood')
        plt.title('Lambda = :' + str(self.l))
        plt.plot([i for i in range(len(self.logLikeData))], self.logLikeData)
        plt.show()
        plt.xlabel('runs')
        plt.ylabel('Relative Change')
        plt.title('Lambda = :' + str(self.l))
        plt.plot([i for i in range(len(self.rcData))], self.rcData)
        plt.show()

    def top10EachTopic(self):
        for i in range(self.k):
            words = sorted(list(self.theta[i].items()), key = lambda a: a[1], reverse=True)[:10]
            print(words)
            



                    
def main():
    with open("dblp-small.txt", 'r', encoding = 'utf-8') as f:
        lines = f.readlines()
        docs = [line.rstrip().split() for line in lines]
    lambdas = [.3]
    for l in lambdas:
        plsa = PLSA(docs, 20, l, .0001, 100)
        plsa.run()
        plsa.graph()
        plsa.top10EachTopic()



if __name__ == '__main__':
    main()