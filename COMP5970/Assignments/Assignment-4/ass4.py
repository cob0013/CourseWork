def main():
    sentence = 'the sun rises in the east and sets in the west'
    probs = {
        'a' : .18,
        'the' : .17,
        'from' : .13,
        'retrieval' : .02,
        'sun' : .05,
        'rises' : .04,
        'in' : .16,
        'BM25' : .01,
        'east' : .02,
        'sets' : .04,
        'west' : .02,
        'and' : .16
     }
    lamb = [.01, .5, .9]
    for l in lamb:
        calc(probs, sentence, l)

def calc(probs, sentence, lamb):
    sentence = sentence.split()
    out = dict()
    for word in probs.keys():
        count = sentence.count(word)
        pmle = count * 1.0 / len(sentence)
        smoothed = (1 - lamb) * pmle + lamb * probs[word] 
        out[word] = smoothed

    for k,v in out.items():
        print(k, v)

if __name__ == '__main__':
    main()
