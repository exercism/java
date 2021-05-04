package account

import "sync"

type Account struct {
	balance int64
	open    bool
	m       sync.RWMutex
}

func Open(initialDeposit int64) *Account {
	if initialDeposit < 0 {
		return nil
	}
	return &Account{initialDeposit, true, sync.RWMutex{}}
}

func (account *Account) Close() (int64, bool) {
	account.m.Lock()
	defer account.m.Unlock()
	if !account.open {
		return 0, false
	}
	account.open = false
	b := account.balance
	account.balance = 0
	return b, true
}

func (account *Account) Balance() (int64, bool) {
	account.m.RLock()
	defer account.m.RUnlock()
	return account.balance, account.open
}

func (account *Account) Deposit(amount int64) (int64, bool) {
	account.m.Lock()
	defer account.m.Unlock()
	if account.balance + amount < 0 {
		return account.balance, false
	}
	account.balance += amount
	return account.balance, account.open
}