package com.barbosa.desafiobackendpicpay.Controller;

import com.barbosa.desafiobackendpicpay.Entities.Wallet.WalletEntity;
import com.barbosa.desafiobackendpicpay.Services.WalletService.Create.WalletCreateDto;
import com.barbosa.desafiobackendpicpay.Services.WalletService.Create.WalletCreateService;
import com.barbosa.desafiobackendpicpay.Services.WalletService.GetWalletInfo.GetWalletInfoDto;
import com.barbosa.desafiobackendpicpay.Services.WalletService.GetWalletInfo.GetWalletInfoService;
import com.barbosa.desafiobackendpicpay.Services.WalletService.IncreaseBalance.IncreaseBalanceDto;
import com.barbosa.desafiobackendpicpay.Services.WalletService.IncreaseBalance.IncreaseBalanceService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
@Validated
public class WalletController {

    @Autowired
    WalletCreateService walletCreateService;

    @Autowired
    IncreaseBalanceService increaseBalanceService;

    @Autowired
    GetWalletInfoService getWalletInfoService;

    @PostMapping("create")
    public ResponseEntity<WalletEntity> create(@Valid @RequestBody WalletCreateDto dto) {
        WalletEntity serviceResponse = walletCreateService.create(dto);
        return new ResponseEntity<>(serviceResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GetWalletInfoDto> get(@PathVariable @NotNull @NotEmpty String id) {
        GetWalletInfoDto serviceResponse = getWalletInfoService.get(id);
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PutMapping("increase")
    public ResponseEntity<String> increase(@Valid @RequestBody IncreaseBalanceDto dto) {
        String serviceResponse = increaseBalanceService.increase(dto);
        return new ResponseEntity<>(serviceResponse, HttpStatus.CREATED);
    }

}
