from itertools import combinations
import math
def main():
    data = open('CACMTest')
    lines = data.readlines()
    document_count = {}
    for document in lines:
        word_pairs = combinations(document.split(), 2)
        pairs_seen_this_doc = set()
        for pair in word_pairs:
            if pair[0] == pair[1]: continue
            pair = tuple(sorted(list(pair)))
            if pair not in document_count:
                document_count[pair] = 0
            if pair not in pairs_seen_this_doc:
                document_count[pair] += 1
                pairs_seen_this_doc.add(pair)
    print(dict(sorted(document_count.items(), key = lambda item: item[1], reverse = True)[:10]))
    mutual_information(document_count, lines)            


def mutual_information(data, documents):
    m_information = dict()
    document_count = len(documents)
    individual_doc_count = document_counts(documents) 
    print(len(data))
    i = 0
    for pair in data.keys():
        #calculate mutal information
        # p(x= 1, y = 1)
        n_both_occur = data[pair]
        n_only_first_occurs =  individual_doc_count[pair[0]] - n_both_occur
        n_only_second_occurs = individual_doc_count[pair[1]] - n_both_occur
        n_none_occur = document_count - n_both_occur - n_only_first_occurs - n_only_second_occurs
        p_both = (n_both_occur + .25) / (1 + document_count)
        p_only_first_occurs = (n_only_first_occurs + .25) / (1 + document_count)
        p_only_second_occurs = (n_only_second_occurs + .25) / (1 + document_count)
        p_none_occur = 1 - p_both - p_only_first_occurs - p_only_second_occurs 
        
        p_first = (n_only_first_occurs + n_both_occur + .5) / (1 + document_count)
        p_second = (n_only_second_occurs + n_both_occur + .5) / (1 + document_count)
        
        p_not_first = 1 - p_first
        p_not_second = 1 - p_second
        mutual_info_this_pair = 0
        mutual_info_this_pair += p_none_occur * math.log(p_none_occur / (p_not_first * p_not_second), 2)
        mutual_info_this_pair += p_only_first_occurs * math.log(p_only_first_occurs / (p_first * p_not_second), 2)
        mutual_info_this_pair +=  p_only_second_occurs * math.log(p_only_second_occurs / (p_not_first * p_second), 2)
        mutual_info_this_pair += p_both * math.log(p_both / (p_first * p_second), 2)
        m_information[pair] = mutual_info_this_pair
        i += 1
    print(dict(sorted(m_information.items(), key = lambda item: item[1], reverse = True)[:10]))
    programming_pairs = []
    for pair in m_information.keys():
        if 'programming' in pair:
            programming_pairs.append((m_information[pair], pair))
    print(sorted(programming_pairs, reverse = True)[:10])
def document_counts(doc):
    counts = {}
    for line in doc:
        seen_this_line = set()
        for word in line.split():
            if word not in counts:
                counts[word] = 0
            if word not in seen_this_line:
                counts[word] += 1
                seen_this_line.add(word)
    return counts
if __name__ == '__main__':
    main()
