
sigs = [
	"6d7b362888208a31cc00996765f7204e7cc858ed65e04643d75599010197cd0a0433e6ed27d53fd79b506abe7d2f8b88a388638fef3d66fe4809847b804e2b60",
	]

def minus(digit):
	if digit <= 127:
		return digit
	else:
		return -(digit - 127)

def hexToDecString(hexString):
	for i in range(0, len(hexString)/2):
		idx = i*2
		print "%d," % minus(int(hexString[idx: idx+2], 16)),
		#print c


for sig in sigs:
	print sig
	hexToDecString(sig)

