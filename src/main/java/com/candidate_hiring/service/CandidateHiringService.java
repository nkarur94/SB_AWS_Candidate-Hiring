package com.candidate_hiring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.candidate_hiring.DTO.CandidateHiringDetailsDTO;
import com.candidate_hiring.DTO.ResponseDTO;
import com.candidate_hiring.entity.CandidateHiringDetailsEntity;
import com.candidate_hiring.exception.CandidateHiringCustomException;
import com.candidate_hiring.repository.CandidateHiringRepo;

@Service
public class CandidateHiringService implements ICandidateHiringService {

	@Autowired
	CandidateHiringRepo repoForHire;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public ResponseDTO addDetailsOfCandidate(String token, CandidateHiringDetailsDTO detailsDTO) {
		// TODO Auto-generated method stub

		String urlForComfirming = "http://localhost:8085/admin/adminpresentornot/" + token;
		boolean presentOrNot = restTemplate.getForObject(urlForComfirming, boolean.class);

		if (presentOrNot != true) {
			throw new CandidateHiringCustomException("Admin  not found");
		} else {

			String urlForverifying = "http://localhost:8085/admin/verifiedOrNot/" + token;
			boolean verifiedOrNot = restTemplate.getForObject(urlForverifying, boolean.class);
			System.out.println(verifiedOrNot);
			
			if (verifiedOrNot != true) {
				throw new CandidateHiringCustomException("admin not verified");

			} else {
				CandidateHiringDetailsEntity entity = new CandidateHiringDetailsEntity(detailsDTO);

				String url = "http://localhost:8085/admin/getadminid/" + token;
				Long id = restTemplate.getForObject(url, Long.class);

				entity.setCreatorUser(id);
				repoForHire.save(entity);
				ResponseDTO response = new ResponseDTO("added details of candidate for hiring", entity);

				return response;

			}

		}
	}

	@Override
	public ResponseDTO updateDetailsOfCandidateHiring(String token, Long CHId, CandidateHiringDetailsDTO detailsDTO) {
		// TODO Auto-generated method stub
		String urlForComfirming = "http://localhost:8085/admin/adminpresentornot/" + token;
		boolean presentOrNot = restTemplate.getForObject(urlForComfirming, boolean.class);

		if (presentOrNot != true) {
			throw new CandidateHiringCustomException("Admin  not found");
		} else {

			String urlForverifying = "http://localhost:8085/admin/verifiedOrNot/" + token;
			boolean verifiedOrNot = restTemplate.getForObject(urlForverifying, boolean.class);

			if (verifiedOrNot != true) {
				throw new CandidateHiringCustomException("Admin not verified");

			} else {

				if (repoForHire.findById(CHId).isPresent()) {
					CandidateHiringDetailsEntity entity = new CandidateHiringDetailsEntity(detailsDTO);

					String url = "http://localhost:8085/admin/getadminid/" + token;
					Long id = restTemplate.getForObject(url, Long.class);

					entity.setCreatorUser(id);

					entity.setCHId(CHId);

					repoForHire.save(entity);
					ResponseDTO response = new ResponseDTO("candidate details updated", entity);
					return response;
				} else {
					throw new CandidateHiringCustomException("candidate id  not found");

				}

			}

		}

	}

	@Override
	public ResponseDTO viewAllDetails(String token) {
		// TODO Auto-generated method stub
		String urlForComfirming = "http://localhost:8085/admin/adminpresentornot/" + token;
		boolean presentOrNot = restTemplate.getForObject(urlForComfirming, boolean.class);

		if (presentOrNot != true) {
			throw new CandidateHiringCustomException("Admin  not found");
		} else {

			String urlForverifying = "http://localhost:8085/admin/verifiedOrNot/" + token;
			boolean verifiedOrNot = restTemplate.getForObject(urlForverifying, boolean.class);

			if (verifiedOrNot != true) {
				throw new CandidateHiringCustomException("Admin not verified");

			} else {

				List<CandidateHiringDetailsEntity> entity = repoForHire.findAll();

				if (entity == null) {
					throw new CandidateHiringCustomException("no details to show");

				} else {
					ResponseDTO response = new ResponseDTO("details of all the candidates dat is been hired", entity);
					return response;
				}
			}
		}
	}

	@Override
	public ResponseDTO viewCandidateById(String token, Long CHId) {
		// TODO Auto-generated method stub
		String urlForComfirming = "http://localhost:8085/admin/adminpresentornot/" + token;
		boolean presentOrNot = restTemplate.getForObject(urlForComfirming, boolean.class);

		if (presentOrNot != true) {
			throw new CandidateHiringCustomException("Admin  not found");
		} else {

			String urlForverifying = "http://localhost:8085/admin/verifiedOrNot/" + token;
			boolean verifiedOrNot = restTemplate.getForObject(urlForverifying, boolean.class);

			if (verifiedOrNot != true) {
				throw new CandidateHiringCustomException("Admin not verified");

			} else {

				CandidateHiringDetailsEntity entity = repoForHire.findById(CHId)
						.orElseThrow(() -> new CandidateHiringCustomException("candidate id not found"));

				ResponseDTO response = new ResponseDTO("candidate details of respective id:" + CHId, entity);
				return response;

			}
		}

	}

	@Override
	public ResponseDTO deleteCandidate(String token, Long CHId) {
		// TODO Auto-generated method stub
		String urlForComfirming = "http://localhost:8085/admin/adminpresentornot/" + token;
		boolean presentOrNot = restTemplate.getForObject(urlForComfirming, boolean.class);

		if (presentOrNot != true) {
			throw new CandidateHiringCustomException("Admin  not found");
		} else {

			String urlForverifying = "http://localhost:8085/admin/verifiedOrNot/" + token;
			boolean verifiedOrNot = restTemplate.getForObject(urlForverifying, boolean.class);

			if (verifiedOrNot != true) {
				throw new CandidateHiringCustomException("Admin not verified");

			} else {
				CandidateHiringDetailsEntity entity = repoForHire.findById(CHId)
						.orElseThrow(() -> new CandidateHiringCustomException("candidate id not found"));

				repoForHire.delete(entity);
				ResponseDTO response = new ResponseDTO("successfully deleted candidate of id:" + CHId);
				return response;
			}
		}
	}

	@Override
	public ResponseDTO updateOnboardingStatus(String token, Long CHId, String onboardingStatus) {
		// TODO Auto-generated method stub
		String urlForComfirming = "http://localhost:8085/admin/adminpresentornot/" + token;
		boolean presentOrNot = restTemplate.getForObject(urlForComfirming, boolean.class);

		if (presentOrNot != true) {
			throw new CandidateHiringCustomException("Admin  not found");
		} else {

			String urlForverifying = "http://localhost:8085/admin/verifiedOrNot/" + token;
			boolean verifiedOrNot = restTemplate.getForObject(urlForverifying, boolean.class);

			if (verifiedOrNot != true) {
				throw new CandidateHiringCustomException("Admin not verified");

			} else {
				CandidateHiringDetailsEntity entity = repoForHire.findById(CHId)
						.orElseThrow(() -> new CandidateHiringCustomException("candidate id not found"));
				entity.setOnboardStatus(onboardingStatus);
				repoForHire.save(entity);

				ResponseDTO response = new ResponseDTO(
						"successfully updated onbording status of candidate:" + entity.getFirstName());
				return response;

			}
		}

	}

	@Override
	public ResponseDTO getCandidateStatusAsActive(String token, String status) {
		// TODO Auto-generated method stub
		String urlForComfirming = "http://localhost:8085/admin/adminpresentornot/" + token;
		boolean presentOrNot = restTemplate.getForObject(urlForComfirming, boolean.class);

		if (presentOrNot != true) {
			throw new CandidateHiringCustomException("Admin  not found");
		} else {

			String urlForverifying = "http://localhost:8085/admin/verifiedOrNot/" + token;
			boolean verifiedOrNot = restTemplate.getForObject(urlForverifying, boolean.class);

			if (verifiedOrNot != true) {
				throw new CandidateHiringCustomException("Admin not verified");

			} else {

				List<CandidateHiringDetailsEntity> entity = repoForHire
						.findByStatusCandidateHiringDetailsEntities(status);
				if (entity == null) {
					ResponseDTO response = new ResponseDTO("no " + status + " candidate available ");
					return response;
				} else {
					ResponseDTO response = new ResponseDTO("candidate details of status::", entity);
					return response;
				}

			}

		}

	}

	@Override
	public ResponseDTO getCandidateStatusCount(String token, String status) {
		// TODO Auto-generated method stub
		String urlForComfirming = "http://localhost:8085/admin/adminpresentornot/" + token;
		boolean presentOrNot = restTemplate.getForObject(urlForComfirming, boolean.class);

		if (presentOrNot != true) {
			throw new CandidateHiringCustomException("Admin  not found");
		} else {

			String urlForverifying = "http://localhost:8085/admin/verifiedOrNot/" + token;
			boolean verifiedOrNot = restTemplate.getForObject(urlForverifying, boolean.class);

			if (verifiedOrNot != true) {
				throw new CandidateHiringCustomException("Admin not verified");

			} else {
					int count = repoForHire.noOfCountForStatusPresent(status);
					if(count == 0) {
						ResponseDTO response = new ResponseDTO("no " + status + " candidate available ");
						return response;
					}else {
						ResponseDTO response = new ResponseDTO("number of " + status + " candidate available are:: "+count);
						return response;
					}
					
			}
		}
		
	}

}
