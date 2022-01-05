import math
import csv
import string
import sys
from collections import Counter
def main():
    csv.field_size_limit(sys.maxsize)
    yearly_documents = dict() 
    with open('state-of-the-union.csv', 'r') as csvfile:
        csvreader = csv.reader(csvfile)
        for row in csvreader:
            year, document = row
            yearly_documents[int(year)] = document.lower().translate(str.maketrans('', '', string.punctuation)).split()
    #each position holds dict of tf for doc
    term_frequencys = [Counter(document) for document in yearly_documents.values()] 
    all_words = []
    for doc in term_frequencys:
        for word in doc.keys():
            all_words.append(word)
    document_frequency = Counter(all_words)
    IDF = dict()
    for k, v in document_frequency.items():
        IDF[k] = math.log(len(yearly_documents) / v, 2)
    TF_IDF = []
    for row in term_frequencys:
        TF_IDF.append(
            {k: v * IDF[k] for k, v in row.items()}
                )
    normalized_tf_idf = []
    for vector in TF_IDF:
        normalized_tf_idf.append(
                {k: v / sum(vector.values()) for k, v in vector.items()}
                )
    #part 1
    random_speech = normalized_tf_idf[211]
    output = dict(sorted(random_speech.items(), key = lambda item: item[1], reverse = True)[:20])
    for k, v in output.items():
        print(k, v)
    #part 2
    years = list(yearly_documents.keys())
    decades =  {}
    start_index = years.index(1900)
    for i in range(start_index, len(years)):
        curr_decade = str(years[i])[:3] + '0' 
        if curr_decade not in decades:
            decades[curr_decade] = {}
        for word, weight in normalized_tf_idf[i].items():
            if word not in decades[curr_decade]:
                decades[curr_decade][word] = 0
            decades[curr_decade][word] += weight

    for decade, vector in decades.items():
        print(f'{decade}s: {sorted(vector.items(), key = lambda item: item[1], reverse = True)[:20]}')



if __name__ == '__main__':
    main()
