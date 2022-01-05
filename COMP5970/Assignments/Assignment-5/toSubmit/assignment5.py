import math
import statistics
import json
import matplotlib.pyplot as plt
import string 

def main():
    threeB()


def dp_score(q, d, u, probs):
    q = q.lower().translate(str.maketrans('', '', string.punctuation)).split()
    d = d.lower().translate(str.maketrans('', '', string.punctuation)).split()
    qd_words = list(set(q) & set(d))
    score = 0
    for word in qd_words:
        a = q.count(word)
        b = d.count(word) / (u * probs[word])
        x = a * math.log(1 + b, 2)
        score += x
    return score - len(q) * math.log(len(d) + u, 2)


def jm_score(q, d, l, probs):
    q = q.lower().translate(str.maketrans('', '', string.punctuation)).split()
    d = d.lower().translate(str.maketrans('', '', string.punctuation)).split()
    qd_words = list(set(q) & set(d))
    score = 0
    for word in qd_words:
        x = ((1- l) * d.count(word)) / (l * probs[word] * len(d) )
        score += q.count(word) * math.log(1 + x, 2)
    return score

def calc_probs():
    corpus = []
    probs = dict()
    f = open('cranfield_data/cranfield_data.json')
    doc_data = json.load(f)
    for document in doc_data:
        d = document['body'].lower().translate(str.maketrans('', '', string.punctuation)).split()
        corpus.extend(d)
    words = set(corpus)
    for word in words:
        probs[word] = corpus.count(word) / len(corpus)
    return probs




def loadRelevanceData():
    f = open('cranfield_data/cranqrel.json')
    relevanceDict = dict()
    data = json.load(f)
    for d in data:
        q = int(d['query_num'])
        r = int(d['position'])
        d_id = int(d['id'])
        if q not in relevanceDict:
            relevanceDict[q] = dict()
        relevanceDict[q][d_id] = r
    return relevanceDict

def threeB():
    lambdas = [.05,0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9]
    f = open('cranfield_data/cran.qry.json')
    queries = json.load(f)
    f = open('cranfield_data/cranfield_data.json')
    documents = json.load(f)
    probs = calc_probs()
    relevance = loadRelevanceData()
    all_performance_scores = []

    for l in lambdas:
        top5_each_q = []
        for i in range(len(queries) - 1):
            scores = []
            for j in range(len(documents)):
                

                q = queries[i]['query']
                d = documents[j]['body']
                score = jm_score(q, d, l, probs)
                scores.append((score, i + 1, j + 1))

            top5_each_q.append(sorted(scores, reverse=True)[:5])
            
        performance_scores = []
        for result in top5_each_q:
            scores_this_qd = []
            for scores, q, d in result:
                if d not in relevance[q]:
                    performance = 5
                else:
                    performance= relevance[q][d]
                scores_this_qd.append(performance)
            performance_scores.append(statistics.mean(scores_this_qd))
        all_performance_scores.append(performance_scores)
    bins = [i for i in range(1, 6)]
    figure, axis = plt.subplots(2, 5)
    axis[0, 0].hist(all_performance_scores[0], bins)
    axis[0, 1].hist(all_performance_scores[1], bins)
    axis[0, 2].hist(all_performance_scores[2], bins)
    axis[0, 3].hist(all_performance_scores[3], bins)
    axis[0, 4].hist(all_performance_scores[4], bins)
    axis[1, 0].hist(all_performance_scores[5], bins)
    axis[1, 1].hist(all_performance_scores[6], bins)
    axis[1, 2].hist(all_performance_scores[7], bins)
    axis[1, 3].hist(all_performance_scores[8], bins)
    axis[1, 4].hist(all_performance_scores[9], bins)
    for i, a in enumerate(figure.axes):
        a.set_xticks([i for i in range(6)])
        a.set_title("lambda=" + str(lambdas[i]))
    plt.show()
    average_performance_scores = [statistics.mean(scores) for scores in all_performance_scores]
    plt.plot(lambdas, average_performance_scores)
    plt.xlabel('lambda')
    plt.ylabel('performace')
    plt.show()

    mus = [100,500,1000,2000,4000,8000,10000]
    all_performance_scores = []
    for u in mus:
        top5_each_q = []
        for i in range(len(queries) - 1):
            scores = []
            for j in range(len(documents)):
                q = queries[i]['query']
                d = documents[j]['body']
                score = dp_score(q, d, u, probs)
                scores.append((score, i + 1, j + 1))
            top5_each_q.append(sorted(scores, reverse=True)[:5])
            

            
        performance_scores = []
        for result in top5_each_q:
            scores_this_qd = []
            for scores, q, d in result:
                if d not in relevance[q]:
                    performance = 5
                else:
                    performance= relevance[q][d]
                scores_this_qd.append(performance)
            performance_scores.append(statistics.mean(scores_this_qd))
        all_performance_scores.append(performance_scores)
    bins = [i for i in range(1, 6)]
    figure, axis = plt.subplots(2, 4)
    axis[0, 0].hist(all_performance_scores[0], bins)
    axis[0, 1].hist(all_performance_scores[1], bins)
    axis[0, 2].hist(all_performance_scores[2], bins)
    axis[0, 3].hist(all_performance_scores[3], bins)
    axis[1, 0].hist(all_performance_scores[4], bins)
    axis[1, 1].hist(all_performance_scores[5], bins)
    axis[1, 2].hist(all_performance_scores[6], bins)
    for i, a in enumerate(figure.axes):
        a.set_xticks([i for i in range(6)])
        if i < 7:
            a.set_title("u=" + str(mus[i]))
    plt.show()
    average_performance_scores = [statistics.mean(scores) for scores in all_performance_scores]
    plt.plot(mus, average_performance_scores)
    plt.xlabel('u')
    plt.ylabel('performace')
    plt.show()



if __name__ == '__main__':
    main()
