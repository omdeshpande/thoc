package com.thoc.user.model;

import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thoc.user.contract.data.UserToken;
import com.thoc.user.database.repository.UserTokenRepository;

@Service
public class UserTokenService implements com.thoc.user.contract.UserTokenService
{
	
	/**
	 * Model mapper to convert DTO to entity and vice versa.
	 */
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * User token entity.
	 */
	@Autowired
	private com.thoc.user.database.entity.UserToken userTokenEntity;
	
	/**
	 * User token repository.
	 */
	@Autowired
	private UserTokenRepository userTokenRepository;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String generateToken()
	{
		return UUID.randomUUID().toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveToken(UserToken userToken)
	{
		// Check if user already has a token, if yes, then update.
		Optional<com.thoc.user.database.entity.UserToken> userTokenEntityOpt = this.userTokenRepository.findByUsername(userToken.getUsername());
		if (userTokenEntityOpt.isPresent()) {
			com.thoc.user.database.entity.UserToken userTokenExisting = userTokenEntityOpt.get();
			userTokenExisting.setId(userToken.getId());
			this.userTokenRepository.save(userTokenExisting);
		} else {
			this.userTokenEntity = this.modelMapper.map(userToken, com.thoc.user.database.entity.UserToken.class);
			this.userTokenRepository.save(this.userTokenEntity);
		}
		
		
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<UserToken> authenticateToken(String token)
	{
		Optional<com.thoc.user.database.entity.UserToken> userTokenEntityOpt = this.userTokenRepository.findById(token);
		if (userTokenEntityOpt.isPresent()) {
			com.thoc.user.database.entity.UserToken userTokenEntity = userTokenEntityOpt.get();
			UserToken userToken = this.modelMapper.map(userTokenEntity, com.thoc.user.model.data.UserToken.class);
			return Optional.of(userToken);
		}
		
		return Optional.empty();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<UserToken> findByUsername(String username) 
	{
		Optional<com.thoc.user.database.entity.UserToken> userTokenEntityOpt = this.userTokenRepository.findByUsername(username);
		if (userTokenEntityOpt.isPresent()) {
			com.thoc.user.database.entity.UserToken userTokenEntity = userTokenEntityOpt.get();
			UserToken userToken = this.modelMapper.map(userTokenEntity, com.thoc.user.model.data.UserToken.class);
			return Optional.of(userToken);
		}
		
		return Optional.empty();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(UserToken userToken) 
	{
		com.thoc.user.database.entity.UserToken userTokenEntity = this.modelMapper.map(userToken, com.thoc.user.database.entity.UserToken.class);
		this.userTokenRepository.delete(userTokenEntity);
		
	}
	
}
