package go.com.controller;

import go.com.service.IAccountService;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@Compensable(interfaceClass = IAccountService.class,
		confirmableKey = "accountServiceConfirm",
		cancellableKey = "accountServiceCancel")
@RestController
public class AccountController implements IAccountService {


	@Autowired
	private JdbcTemplate jdbcTemplate;

	@ResponseBody
	@RequestMapping(value = "/increase", method = RequestMethod.POST)
	@Transactional
	public void increaseAmount(@RequestParam("acctId") String acctId, @RequestParam("amount") double amount) {
		int value = this.jdbcTemplate.update("update tb_account_one set frozen = frozen + ? where acct_id = ?", amount, acctId);
		int i=0;
		i=1/i;
		if (value != 1) {
			throw new IllegalStateException("ERROR!");
		}
		System.out.printf("exec increase: acct= %s, amount= %7.2f%n", acctId, amount);
	}

	@ResponseBody
	@RequestMapping(value = "/decrease", method = RequestMethod.POST)
	@Transactional
	public void decreaseAmount(@RequestParam("acctId") String acctId, @RequestParam("amount") double amount) {
		int value = this.jdbcTemplate.update(
				"update tb_account_one set amount = amount - ?, frozen = frozen + ? where acct_id = ?", amount, amount, acctId);
		if (value != 1) {
			throw new IllegalStateException("ERROR!");
		}
		System.out.printf("exec decrease: acct= %s, amount= %7.2f%n", acctId, amount);
	}

}
